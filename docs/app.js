// Plan Dietético Clínico & Compras Agora (Plaza Vea) — Interactive Web App Engine
(function () {
  const STORAGE_KEY = "plan_dietetico_clinical_v2";
  const DATA = window.PLAN_DATA;

  function computeTodayIndex() {
    const jsDay = new Date().getDay(); // 0=Dom, 1=Lun..6=Sab
    return jsDay === 0 ? 6 : jsDay - 1;
  }

  function loadPersisted() {
    try {
      const raw = localStorage.getItem(STORAGE_KEY);
      if (raw) return JSON.parse(raw);
    } catch (_) {}
    return {};
  }

  const saved = loadPersisted();

  const state = {
    activeTab: "plan", // "plan" | "shop" | "health"
    selectedDayIndex: computeTodayIndex(),
    todayIndex: computeTodayIndex(),
    showAllWeek: false,
    selectedSlot: "all",
    mealSearch: "",
    shopCategory: "all",
    shopSearch: "",
    hideCheckedShop: false,
    showPortionGuide: false,
    modalMealId: null,
    activeTimerIdx: 0,
    timerRemaining: 0,
    timerTotal: 0,
    timerRunning: false,
    completedMeals: new Set(saved.completedMeals || []),
    checkedShopIds: new Set(saved.checkedShopIds || []),
    checkedIngKeys: new Set(saved.checkedIngKeys || []),
    dailyHealth: saved.dailyHealth || {},
    currentWeightKg: typeof saved.currentWeightKg === "number" ? saved.currentWeightKg : 123.0,
    customBiomarkers: saved.customBiomarkers || {}
  };

  let timerInterval = null;

  function persist() {
    try {
      localStorage.setItem(
        STORAGE_KEY,
        JSON.stringify({
          completedMeals: Array.from(state.completedMeals),
          checkedShopIds: Array.from(state.checkedShopIds),
          checkedIngKeys: Array.from(state.checkedIngKeys),
          dailyHealth: state.dailyHealth,
          currentWeightKg: state.currentWeightKg,
          customBiomarkers: state.customBiomarkers
        })
      );
    } catch (_) {}
  }

  function getDayHealth(dayIdx) {
    return (
      state.dailyHealth[dayIdx] || {
        waterGlasses: 0,
        irbesartanTaken: false,
        bisoprololTaken: false,
        workoutDone: false
      }
    );
  }

  function setDayHealth(dayIdx, updater) {
    const current = getDayHealth(dayIdx);
    state.dailyHealth[dayIdx] = updater({ ...current });
    persist();
    render();
  }

  function showToast(msg) {
    const toast = document.getElementById("toast-banner");
    if (!toast) return;
    toast.textContent = msg;
    toast.classList.remove("opacity-0", "pointer-events-none", "translate-y-4");
    toast.classList.add("opacity-100", "translate-y-0");
    clearTimeout(window.__toastTimer);
    window.__toastTimer = setTimeout(() => {
      toast.classList.add("opacity-0", "pointer-events-none", "translate-y-4");
      toast.classList.remove("opacity-100", "translate-y-0");
    }, 2600);
  }

  function playBeep() {
    try {
      const ctx = new (window.AudioContext || window.webkitAudioContext)();
      const osc = ctx.createOscillator();
      const gain = ctx.createGain();
      osc.type = "sine";
      osc.frequency.setValueAtTime(880, ctx.currentTime);
      gain.gain.setValueAtTime(0.18, ctx.currentTime);
      osc.connect(gain);
      gain.connect(ctx.destination);
      osc.start();
      osc.stop(ctx.currentTime + 0.45);
    } catch (_) {}
  }

  function allMealsFlat() {
    const list = [];
    DATA.days.forEach((d) => {
      d.meals.forEach((m) => {
        list.push({ ...m, dayIndex: d.dayIndex, dayName: d.dayName, optionLabel: d.optionLabel });
      });
    });
    return list;
  }

  function getDayTotals(day) {
    return day.meals.reduce(
      (acc, m) => {
        acc.kcal += m.macros.kcal;
        acc.prot += m.macros.prot;
        acc.carb += m.macros.carb;
        acc.fat += m.macros.fat;
        acc.fiber += m.macros.fiber;
        return acc;
      },
      { kcal: 0, prot: 0, carb: 0, fat: 0, fiber: 0 }
    );
  }

  function getDayConsumed(day) {
    return day.meals
      .filter((m) => state.completedMeals.has(m.id))
      .reduce(
        (acc, m) => {
          acc.kcal += m.macros.kcal;
          acc.prot += m.macros.prot;
          acc.carb += m.macros.carb;
          acc.fat += m.macros.fat;
          acc.fiber += m.macros.fiber;
          return acc;
        },
        { kcal: 0, prot: 0, carb: 0, fat: 0, fiber: 0 }
      );
  }

  function stopTimerLoop() {
    if (timerInterval) {
      clearInterval(timerInterval);
      timerInterval = null;
    }
    state.timerRunning = false;
  }

  function initModalTimers(mealId, timerIdx) {
    stopTimerLoop();
    const meal = allMealsFlat().find((m) => m.id === mealId);
    if (!meal || !meal.timers || meal.timers.length === 0) {
      state.activeTimerIdx = 0;
      state.timerRemaining = 0;
      state.timerTotal = 0;
      return;
    }
    const idx = Math.max(0, Math.min(timerIdx || 0, meal.timers.length - 1));
    state.activeTimerIdx = idx;
    state.timerTotal = meal.timers[idx].durationSeconds;
    state.timerRemaining = meal.timers[idx].durationSeconds;
  }

  function toggleTimerRun() {
    if (state.timerTotal <= 0) return;
    if (state.timerRunning) {
      stopTimerLoop();
      renderModal();
      return;
    }
    if (state.timerRemaining <= 0) {
      state.timerRemaining = state.timerTotal;
    }
    state.timerRunning = true;
    timerInterval = setInterval(() => {
      if (state.timerRemaining > 0) {
        state.timerRemaining -= 1;
        renderModalTimerOnly();
        if (state.timerRemaining <= 0) {
          stopTimerLoop();
          playBeep();
          showToast("¡Tiempo del cronómetro cumplido!");
          renderModal();
        }
      }
    }, 1000);
    renderModal();
  }

  function resetTimer() {
    stopTimerLoop();
    state.timerRemaining = state.timerTotal;
    renderModal();
  }

  function formatTime(secs) {
    const m = Math.floor(secs / 60);
    const s = secs % 60;
    return String(m).padStart(2, "0") + ":" + String(s).padStart(2, "0");
  }

  function renderModalTimerOnly() {
    const timeEl = document.getElementById("modal-timer-clock");
    const barEl = document.getElementById("modal-timer-bar");
    if (timeEl) {
      timeEl.textContent = state.timerRemaining <= 0 ? "¡Tiempo cumplido!" : formatTime(state.timerRemaining);
    }
    if (barEl && state.timerTotal > 0) {
      const pct = Math.max(0, Math.min(100, (state.timerRemaining / state.timerTotal) * 100));
      barEl.style.width = pct + "%";
    }
  }

  function buildKeepText() {
    const lines = [];
    lines.push("🛒 LISTA DE COMPRAS REAL EN PLAZA VEA VÍA AGORA — PLAN LIC. ISABEL RÍOS");
    lines.push(
      `💰 Semana 1 (Carrito completo): S/ ${DATA.financials.week1Total.toFixed(2)} | Semanas 2–4 (Reposición): S/ ${DATA.financials.weeklyReplenishment.toFixed(2)}/sem | Costo Real Consumido: S/ ${DATA.financials.netWeeklyConsumed.toFixed(2)}/sem`
    );
    lines.push("------------------------------------------------------------");
    ["1", "2", "3", "4"].forEach((code) => {
      const cat = DATA.shoppingCategories.find((c) => c.code === code);
      lines.push("");
      lines.push(cat.sectionHeader.toUpperCase());
      DATA.shoppingItems
        .filter((it) => it.category === code)
        .forEach((it) => {
          const mark = state.checkedShopIds.has(it.id) ? "[x]" : "[ ]";
          lines.push(
            `${mark} ${it.skuLabel} • ${it.name} — ${it.quantity} | Caja: S/ ${it.priceSoles.toFixed(2)} (Costo real: S/ ${it.weeklyCostSoles.toFixed(2)}/sem) | ${it.usageNote}`
          );
        });
    });
    return lines.join("\n");
  }

  function buildRecipeShareText(meal) {
    const lines = [
      `${meal.dayName.toUpperCase()} (${meal.optionLabel}) — ${meal.time} • ${meal.slotLabel}`,
      `Plato: ${meal.title}`,
      `Macros Fitia Pro: ${meal.macros.kcal} kcal | ${meal.macros.prot}g Prot | ${meal.macros.carb}g Carbos | ${meal.macros.fat}g Grasas | ${meal.macros.fiber}g Fibra`
    ];
    if (meal.medAlert) lines.push(`Recordatorio: ${meal.medAlert}`);
    lines.push("", "INGREDIENTES EXACTOS (PLAZA VEA / AGORA):");
    meal.ingredients.forEach((i) => lines.push(`• ${i}`));
    lines.push("", "PREPARACIÓN PASO A PASO:");
    meal.steps.forEach((s, idx) => lines.push(`${idx + 1}. ${s}`));
    lines.push("", `NOTA CLÍNICA: ${meal.clinicalNote}`);
    return lines.join("\n");
  }

  // Global actions attached to window.APP
  window.APP = {
    setTab(tab) {
      state.activeTab = tab;
      render();
      window.scrollTo({ top: 0, behavior: "smooth" });
    },
    selectDay(idx) {
      state.selectedDayIndex = idx;
      state.showAllWeek = false;
      render();
    },
    toggleShowAllWeek() {
      state.showAllWeek = !state.showAllWeek;
      render();
    },
    setSlot(slot) {
      state.selectedSlot = slot;
      render();
    },
    setMealSearch(val) {
      state.mealSearch = val;
      render();
    },
    toggleMealDone(mealId, ev) {
      if (ev) ev.stopPropagation();
      if (state.completedMeals.has(mealId)) {
        state.completedMeals.delete(mealId);
      } else {
        state.completedMeals.add(mealId);
      }
      persist();
      render();
      if (state.modalMealId === mealId) renderModal();
    },
    openRecipe(mealId) {
      state.modalMealId = mealId;
      initModalTimers(mealId, 0);
      renderModal();
    },
    closeRecipe() {
      stopTimerLoop();
      state.modalMealId = null;
      renderModal();
    },
    navModal(dir) {
      if (!state.modalMealId) return;
      const flat = allMealsFlat();
      const idx = flat.findIndex((m) => m.id === state.modalMealId);
      if (idx === -1) return;
      const next = (idx + dir + flat.length) % flat.length;
      state.modalMealId = flat[next].id;
      initModalTimers(state.modalMealId, 0);
      renderModal();
    },
    selectModalTimer(idx) {
      if (!state.modalMealId) return;
      initModalTimers(state.modalMealId, idx);
      renderModal();
    },
    toggleTimerRun,
    resetTimer,
    toggleIngredient(mealId, idx) {
      const key = `${mealId}_${idx}`;
      if (state.checkedIngKeys.has(key)) state.checkedIngKeys.delete(key);
      else state.checkedIngKeys.add(key);
      persist();
      renderModal();
    },
    copyRecipe() {
      const meal = allMealsFlat().find((m) => m.id === state.modalMealId);
      if (!meal) return;
      navigator.clipboard.writeText(buildRecipeShareText(meal));
      showToast("Receta copiada al portapapeles");
    },
    toggleMed(dayIdx, field, label) {
      setDayHealth(dayIdx, (h) => {
        h[field] = !h[field];
        showToast(h[field] ? `${label} registrado` : `${label} pendiente`);
        return h;
      });
    },
    addWater(dayIdx, delta) {
      setDayHealth(dayIdx, (h) => {
        const next = Math.max(0, Math.min(13, (h.waterGlasses || 0) + delta));
        h.waterGlasses = next;
        return h;
      });
    },
    setWaterGlass(dayIdx, glassNum) {
      setDayHealth(dayIdx, (h) => {
        h.waterGlasses = h.waterGlasses === glassNum ? glassNum - 1 : glassNum;
        return h;
      });
    },
    setShopCat(code) {
      state.shopCategory = code;
      render();
    },
    setShopSearch(val) {
      state.shopSearch = val;
      render();
    },
    toggleHideCheckedShop() {
      state.hideCheckedShop = !state.hideCheckedShop;
      render();
    },
    togglePortionGuide() {
      state.showPortionGuide = !state.showPortionGuide;
      render();
    },
    toggleShopItem(id) {
      if (state.checkedShopIds.has(id)) state.checkedShopIds.delete(id);
      else state.checkedShopIds.add(id);
      persist();
      render();
    },
    toggleShopCatAll(code) {
      const items = DATA.shoppingItems.filter((it) =>
        code === "all" ? true : code === "frescos" ? it.isWeeklyReplenishment : it.category === code
      );
      const allChecked = items.length > 0 && items.every((it) => state.checkedShopIds.has(it.id));
      items.forEach((it) => {
        if (allChecked) state.checkedShopIds.delete(it.id);
        else state.checkedShopIds.add(it.id);
      });
      persist();
      showToast(allChecked ? "Sección desmarcada" : "Sección marcada en carrito Agora");
      render();
    },
    clearAllShop() {
      if (!confirm("¿Desmarcar los 35 insumos de la lista de compras de Plaza Vea vía Agora?")) return;
      state.checkedShopIds.clear();
      persist();
      showToast("Lista de compras desmarcada");
      render();
    },
    copyKeepList() {
      navigator.clipboard.writeText(buildKeepText());
      showToast("Lista de 35 insumos Agora copiada para Google Keep");
    },
    stepWeight(delta) {
      state.currentWeightKg = Math.max(50, Math.min(220, Math.round((state.currentWeightKg + delta) * 10) / 10));
      persist();
      showToast(`Peso actualizado: ${state.currentWeightKg.toFixed(1)} kg`);
      render();
    },
    promptWeight() {
      const val = prompt("Ingresa tu peso actual en kg (Meta clínica: de 123.0 kg a 81.0 kg):", state.currentWeightKg.toFixed(1));
      if (!val) return;
      const num = parseFloat(val.replace(",", "."));
      if (!isNaN(num) && num >= 40 && num <= 250) {
        state.currentWeightKg = Math.round(num * 10) / 10;
        persist();
        showToast(`Peso guardado: ${state.currentWeightKg.toFixed(1)} kg`);
        render();
      }
    },
    promptBiomarker(id) {
      const marker = DATA.biomarkers.find((b) => b.id === id);
      if (!marker) return;
      const current = state.customBiomarkers[id] || marker.defaultValueText;
      const val = prompt(`Actualizar ${marker.label} (${marker.subUnit})\n${marker.targetText}:`, current);
      if (val && val.trim()) {
        state.customBiomarkers[id] = val.trim();
        persist();
        showToast(`${marker.label} actualizado`);
        render();
      }
    },
    resetWeek() {
      if (!confirm("¿Reiniciar comidas completadas, vasos de agua y medicación de la semana?")) return;
      state.completedMeals.clear();
      state.checkedIngKeys.clear();
      state.dailyHealth = {};
      persist();
      showToast("Progreso semanal reiniciado");
      render();
    }
  };

  function renderHeader() {
    const insulin = state.customBiomarkers["insulina"] || "39.0";
    const uric = state.customBiomarkers["urico"] || "6.65";
    const tgp = state.customBiomarkers["tgp"] || "49.9";
    const weightStr = state.currentWeightKg.toFixed(1).replace(/\.0$/, "");
    const pendingShop = Math.max(0, DATA.shoppingItems.length - state.checkedShopIds.size);

    document.getElementById("hdr-weight-pill").textContent = `${weightStr} → 81 kg`;
    document.getElementById("hdr-meals-done").textContent = `${state.completedMeals.size}/35 listas`;
    document.getElementById("hdr-insulin").textContent = `Insulina: ${insulin}`;
    document.getElementById("hdr-uric-tgp").textContent = `Úrico: ${uric} | TGP: ${tgp}`;

    const badge = document.getElementById("nav-shop-badge");
    if (badge) {
      badge.textContent = pendingShop;
      badge.style.display = pendingShop > 0 ? "inline-flex" : "none";
    }

    ["plan", "shop", "health"].forEach((t) => {
      const btn = document.getElementById(`tab-btn-${t}`);
      if (!btn) return;
      if (state.activeTab === t) {
        btn.className =
          "flex-1 py-2.5 px-3 rounded-xl font-bold text-sm flex items-center justify-center gap-2 bg-emerald-700 text-white shadow-sm transition";
      } else {
        btn.className =
          "flex-1 py-2.5 px-3 rounded-xl font-semibold text-sm flex items-center justify-center gap-2 text-slate-600 hover:bg-slate-100 transition";
      }
    });
  }

  function slotBadgeStyle(slot) {
    switch (slot) {
      case "desayuno":
        return { bg: "bg-amber-100 text-amber-800", strip: "bg-amber-600" };
      case "media_manana":
        return { bg: "bg-emerald-100 text-emerald-900", strip: "bg-emerald-600" };
      case "almuerzo":
        return { bg: "bg-sky-100 text-sky-800", strip: "bg-sky-600" };
      case "media_tarde":
        return { bg: "bg-purple-100 text-purple-800", strip: "bg-purple-600" };
      case "cena":
        return { bg: "bg-indigo-100 text-indigo-800", strip: "bg-indigo-600" };
      default:
        return { bg: "bg-emerald-100 text-emerald-800", strip: "bg-emerald-600" };
    }
  }

  function renderPlanTab() {
    const selectedDay = DATA.days[state.selectedDayIndex] || DATA.days[0];
    const totals = getDayTotals(selectedDay);
    const consumed = getDayConsumed(selectedDay);
    const health = getDayHealth(state.selectedDayIndex);
    const liters = ((health.waterGlasses || 0) * 0.25).toFixed(2);
    const kcalPct = totals.kcal > 0 ? Math.min(100, Math.round((consumed.kcal / totals.kcal) * 100)) : 0;

    const dayPillsHtml = DATA.days
      .map((d, idx) => {
        const isSel = !state.showAllWeek && idx === state.selectedDayIndex;
        const isToday = idx === state.todayIndex;
        const doneCount = d.meals.filter((m) => state.completedMeals.has(m.id)).length;
        return `
        <button onclick="APP.selectDay(${idx})"
          class="flex-1 min-w-[46px] py-2 px-1 rounded-2xl border text-center transition ${
            isSel
              ? "bg-emerald-700 text-white border-emerald-900 shadow-sm"
              : isToday
              ? "bg-slate-50 text-slate-900 border-emerald-600"
              : "bg-slate-50 text-slate-700 border-slate-200 hover:bg-slate-100"
          }">
          <div class="text-[10px] font-bold ${isSel ? "text-emerald-100" : isToday ? "text-emerald-700" : "text-slate-400"}">
            ${isToday ? "HOY" : "OP " + (idx + 1)}
          </div>
          <div class="text-sm font-extrabold">${d.shortName}</div>
          <div class="text-[11px] ${isSel ? "text-emerald-100" : doneCount === 5 ? "text-emerald-600 font-bold" : "text-slate-400"}">
            ${doneCount}/5
          </div>
        </button>`;
      })
      .join("");

    const slots = [
      { id: "all", label: "Todas (5)" },
      { id: "desayuno", label: "08:00 Desayuno" },
      { id: "media_manana", label: "10:30 Pre-entreno" },
      { id: "almuerzo", label: "14:00 Almuerzo" },
      { id: "media_tarde", label: "16:30 Media Tarde" },
      { id: "cena", label: "19:00 Cena" }
    ];

    const slotChipsHtml = slots
      .map(
        (s) => `
      <button onclick="APP.setSlot('${s.id}')"
        class="px-3 py-1.5 rounded-xl text-xs font-bold whitespace-nowrap border transition ${
          state.selectedSlot === s.id
            ? "bg-slate-900 text-white border-slate-900"
            : "bg-white text-slate-700 border-slate-200 hover:bg-slate-50"
        }">
        ${s.label}
      </button>`
      )
      .join("");

    const q = state.mealSearch.trim().toLowerCase();
    const daysToDisplay = state.showAllWeek || q.length > 0 ? DATA.days : [selectedDay];

    let mealsHtml = "";
    daysToDisplay.forEach((day) => {
      const filtered = day.meals.filter((m) => {
        const slotOk = state.selectedSlot === "all" || m.slot === state.selectedSlot;
        const qOk =
          !q ||
          m.title.toLowerCase().includes(q) ||
          m.shortDesc.toLowerCase().includes(q) ||
          m.ingredients.some((i) => i.toLowerCase().includes(q));
        return slotOk && qOk;
      });

      if (filtered.length > 0) {
        if (state.showAllWeek || q.length > 0) {
          mealsHtml += `
            <div class="flex items-center justify-between pt-3 px-1">
              <span class="text-xs font-extrabold tracking-wide text-slate-800 uppercase">${day.dayName} • OPCIÓN ${day.dayIndex + 1}</span>
              <span class="text-xs font-bold text-emerald-700">${day.focusTag}</span>
            </div>`;
        }
        filtered.forEach((meal) => {
          const isDone = state.completedMeals.has(meal.id);
          const st = slotBadgeStyle(meal.slot);
          mealsHtml += `
            <div onclick="APP.openRecipe('${meal.id}')"
              class="group cursor-pointer rounded-2xl border ${
                isDone ? "bg-emerald-50/40 border-emerald-300" : "bg-white border-slate-200 hover:border-emerald-400"
              } shadow-sm overflow-hidden flex transition">
              <div class="w-1.5 ${st.strip}"></div>
              <div class="p-4 flex-1 space-y-2.5">
                <div class="flex items-center justify-between gap-2">
                  <div class="flex items-center gap-2 flex-wrap">
                    <span class="px-2.5 py-1 rounded-lg text-xs font-bold ${st.bg}">
                      ${meal.time} • ${meal.slotLabel}
                    </span>
                    ${
                      meal.timers && meal.timers.length > 0
                        ? `<span class="px-2 py-0.5 rounded-lg text-[11px] font-bold bg-slate-100 text-emerald-700">⏱ ${meal.timers.length} cronómetro${meal.timers.length > 1 ? "s" : ""}</span>`
                        : ""
                    }
                  </div>
                  <button onclick="APP.toggleMealDone('${meal.id}', event)"
                    title="${isDone ? "Desmarcar comida" : "Marcar comida completada"}"
                    class="w-9 h-9 rounded-full flex items-center justify-center border transition ${
                      isDone
                        ? "bg-emerald-600 border-emerald-600 text-white"
                        : "bg-slate-100 border-slate-300 text-slate-500 hover:bg-emerald-50"
                    }">
                    ✓
                  </button>
                </div>
                <h3 class="text-base font-extrabold ${isDone ? "line-through text-slate-400" : "text-slate-900"}">
                  ${meal.title}
                </h3>
                <p class="text-xs text-slate-600 leading-relaxed">${meal.shortDesc}</p>
                ${
                  meal.medAlert
                    ? `<div class="px-3 py-1.5 rounded-xl bg-sky-50 border border-sky-200 text-[11px] font-semibold text-sky-800 flex items-center gap-1.5">
                        <span>🔔</span> <span>${meal.medAlert}</span>
                      </div>`
                    : ""
                }
                <div class="pt-2 border-t border-slate-100 flex items-center justify-between text-xs">
                  <span class="font-semibold text-slate-600">
                    ${meal.macros.kcal} kcal • ${meal.macros.prot}g Prot • ${meal.macros.carb}g C • ${meal.macros.fiber}g Fibra
                  </span>
                  <span class="font-extrabold text-emerald-700 group-hover:translate-x-0.5 transition">
                    Ver Receta →
                  </span>
                </div>
              </div>
            </div>`;
        });
      }
    });

    if (!mealsHtml) {
      mealsHtml = `
        <div class="bg-white rounded-2xl border border-slate-200 p-8 text-center text-slate-500 text-sm">
          No se encontraron comidas con ese filtro.
        </div>`;
    }

    return `
      <div class="space-y-4">
        <!-- Selector de Día -->
        <div class="bg-white rounded-2xl border border-slate-200 p-3.5 shadow-sm space-y-2.5">
          <div class="flex items-center justify-between px-1">
            <span class="text-[11px] font-extrabold text-slate-500 uppercase tracking-wider">Selecciona el día (Opciones 1 a 7)</span>
            <button onclick="APP.toggleShowAllWeek()" class="text-xs font-bold text-emerald-700 hover:underline">
              ${state.showAllWeek ? "Ver día actual" : "Ver 7 días juntos"}
            </button>
          </div>
          <div class="flex gap-1.5 overflow-x-auto pb-1">${dayPillsHtml}</div>
        </div>

        <!-- Resumen Diario + Consumo Fitia + Medicación + Agua -->
        <div class="bg-white rounded-2xl border border-slate-200 p-4 shadow-sm space-y-3">
          <div class="flex flex-wrap items-center justify-between gap-2">
            <div>
              <div class="text-[11px] font-extrabold text-emerald-700 uppercase">${selectedDay.optionLabel}</div>
              <div class="text-base font-extrabold text-slate-900">${selectedDay.dayName} — ${selectedDay.focusTag}</div>
            </div>
            <div class="px-3 py-1.5 rounded-xl bg-slate-100 text-xs font-bold text-slate-800">
              Meta: ${totals.kcal} kcal • ${totals.prot}g P • ${totals.fiber}g Fibra
            </div>
          </div>

          <!-- Barra de Consumo Hoy (Estilo Fitia) -->
          <div class="p-3 rounded-xl bg-emerald-50/70 border border-emerald-200 space-y-1.5">
            <div class="flex items-center justify-between text-xs">
              <span class="font-extrabold text-emerald-800 uppercase">Consumo Hoy (Estilo Fitia)</span>
              <span class="font-extrabold text-emerald-950">${consumed.kcal} / ${totals.kcal} kcal (${kcalPct}%)</span>
            </div>
            <div class="w-full h-2 rounded-full bg-emerald-100 overflow-hidden">
              <div class="h-full bg-emerald-600 transition-all duration-300" style="width:${kcalPct}%"></div>
            </div>
            <div class="flex flex-wrap justify-between text-[11px] font-semibold pt-0.5">
              <span class="text-emerald-900">Prot: ${consumed.prot}/${totals.prot}g</span>
              <span class="text-amber-900">Carbos: ${consumed.carb}/${totals.carb}g</span>
              <span class="text-sky-900">Grasas: ${consumed.fat}/${totals.fat}g</span>
              <span class="text-emerald-900">Fibra: ${consumed.fiber}/${totals.fiber}g</span>
            </div>
          </div>

          <!-- Chips rápidos de Medicación y Entreno -->
          <div class="grid grid-cols-3 gap-2">
            <button onclick="APP.toggleMed(${state.selectedDayIndex}, 'irbesartanTaken', 'Irbesartán 150 mg (08:00 AM)')"
              class="p-2.5 rounded-xl border text-left transition ${
                health.irbesartanTaken
                  ? "bg-emerald-50 border-emerald-600 text-emerald-900"
                  : "bg-sky-50/70 border-sky-200 text-slate-800"
              }">
              <div class="text-[10px] font-bold ${health.irbesartanTaken ? "text-emerald-700" : "text-sky-700"}">08:00 AM</div>
              <div class="text-xs font-extrabold truncate">${health.irbesartanTaken ? "✓ " : ""}Irbesartán</div>
            </button>
            <button onclick="APP.toggleMed(${state.selectedDayIndex}, 'workoutDone', 'Entreno 2x2 m (11:00 AM)')"
              class="p-2.5 rounded-xl border text-left transition ${
                health.workoutDone
                  ? "bg-emerald-50 border-emerald-600 text-emerald-900"
                  : "bg-emerald-50/50 border-emerald-200 text-slate-800"
              }">
              <div class="text-[10px] font-bold text-emerald-700">11:00 AM</div>
              <div class="text-xs font-extrabold truncate">${health.workoutDone ? "✓ " : ""}Entreno 2x2</div>
            </button>
            <button onclick="APP.toggleMed(${state.selectedDayIndex}, 'bisoprololTaken', 'Bisoprolol 2.5 mg (14:00 PM)')"
              class="p-2.5 rounded-xl border text-left transition ${
                health.bisoprololTaken
                  ? "bg-emerald-50 border-emerald-600 text-emerald-900"
                  : "bg-indigo-50/70 border-indigo-200 text-slate-800"
              }">
              <div class="text-[10px] font-bold ${health.bisoprololTaken ? "text-emerald-700" : "text-indigo-700"}">14:00 PM</div>
              <div class="text-xs font-extrabold truncate">${health.bisoprololTaken ? "✓ " : ""}Bisoprolol</div>
            </button>
          </div>

          <!-- Hidratación rápida -->
          <div class="p-3 rounded-xl bg-sky-50 border border-sky-200 flex items-center justify-between gap-2">
            <div>
              <div class="text-xs font-extrabold text-sky-800">💧 Hidratación Renal: ${liters} L / 3.25 L</div>
              <div class="text-[11px] text-slate-600">${health.waterGlasses || 0} de 13 vasos (250 ml c/u)</div>
            </div>
            <button onclick="APP.addWater(${state.selectedDayIndex}, 1)"
              class="px-3.5 py-2 rounded-xl bg-sky-600 hover:bg-sky-700 text-white text-xs font-extrabold shadow-sm transition">
              +1 Vaso
            </button>
          </div>
        </div>

        <!-- Recordatorio de Preparación Nocturna (12 h antes) -->
        <div class="p-3.5 rounded-2xl bg-amber-50 border border-amber-300/80 flex items-start gap-3">
          <div class="w-8 h-8 rounded-xl bg-amber-100 text-amber-800 flex items-center justify-center font-bold shrink-0">🌙</div>
          <div class="text-xs space-y-0.5">
            <div class="font-extrabold text-amber-800 uppercase">Preparación Nocturna (Almidón Resistente / Remojo 12 h antes)</div>
            <p class="text-amber-950 leading-relaxed">${selectedDay.nightPrepReminder}</p>
          </div>
        </div>

        <!-- Buscador y Filtros de Horario -->
        <div class="space-y-2">
          <input type="search" value="${state.mealSearch.replace(/"/g, "&quot;")}"
            oninput="APP.setMealSearch(this.value)"
            placeholder="Buscar plato o ingrediente (ej. atún, pavita, avena, basa, lentejas)…"
            class="w-full px-4 py-2.5 rounded-2xl bg-white border border-slate-200 text-sm focus:outline-none focus:border-emerald-600 shadow-sm" />
          <div class="flex gap-1.5 overflow-x-auto pb-1">${slotChipsHtml}</div>
        </div>

        <!-- Lista de Comidas -->
        <div class="space-y-3">${mealsHtml}</div>
      </div>
    `;
  }

  function renderShopTab() {
    const totalCount = DATA.shoppingItems.length;
    const checkedCount = DATA.shoppingItems.filter((i) => state.checkedShopIds.has(i.id)).length;
    const checkedSoles = DATA.shoppingItems
      .filter((i) => state.checkedShopIds.has(i.id))
      .reduce((s, i) => s + i.priceSoles, 0);
    const pendingSoles = Math.max(0, DATA.financials.week1Total - checkedSoles);
    const pct = Math.min(100, Math.round((checkedSoles / DATA.financials.week1Total) * 100));

    const catChipsHtml = DATA.shoppingCategories
      .map(
        (c) => `
      <button onclick="APP.setShopCat('${c.code}')"
        class="px-3 py-1.5 rounded-xl text-xs font-bold whitespace-nowrap border transition ${
          state.shopCategory === c.code
            ? "bg-slate-900 text-white border-slate-900"
            : "bg-white text-slate-700 border-slate-200 hover:bg-slate-50"
        }">
        ${c.chipTitle}
      </button>`
      )
      .join("");

    const q = state.shopSearch.trim().toLowerCase();
    const filtered = DATA.shoppingItems.filter((it) => {
      const catOk =
        state.shopCategory === "all"
          ? true
          : state.shopCategory === "frescos"
          ? it.isWeeklyReplenishment
          : it.category === state.shopCategory;
      const hideOk = !state.hideCheckedShop || !state.checkedShopIds.has(it.id);
      const qOk =
        !q ||
        it.name.toLowerCase().includes(q) ||
        it.skuLabel.toLowerCase().includes(q) ||
        it.quantity.toLowerCase().includes(q) ||
        it.usageNote.toLowerCase().includes(q);
      return catOk && hideOk && qOk;
    });

    let groupsHtml = "";
    ["1", "2", "3", "4"].forEach((code) => {
      const cat = DATA.shoppingCategories.find((c) => c.code === code);
      const list = filtered.filter((i) => i.category === code);
      if (list.length === 0) return;
      const catTotal = list.reduce((s, i) => s + i.priceSoles, 0);
      const catWeekly = list.reduce((s, i) => s + i.weeklyCostSoles, 0);
      const catChecked = list.filter((i) => state.checkedShopIds.has(i.id)).length;

      const rowsHtml = list
        .map((item) => {
          const isChecked = state.checkedShopIds.has(item.id);
          return `
          <div onclick="APP.toggleShopItem('${item.id}')"
            class="p-3.5 flex items-start gap-3 cursor-pointer border-b last:border-b-0 border-slate-100 transition ${
              isChecked ? "bg-emerald-50/50" : "hover:bg-slate-50"
            }">
            <input type="checkbox" ${isChecked ? "checked" : ""}
              onclick="event.stopPropagation(); APP.toggleShopItem('${item.id}')"
              class="mt-1 w-4 h-4 accent-emerald-600 rounded cursor-pointer" />
            <div class="flex-1 min-w-0 space-y-1">
              <div class="flex items-start justify-between gap-2">
                <div>
                  <div class="flex items-center gap-1.5 flex-wrap mb-1">
                    <span class="px-2 py-0.5 rounded bg-amber-100 text-slate-900 text-[10px] font-extrabold">${item.skuLabel}</span>
                    ${
                      item.isWeeklyReplenishment
                        ? `<span class="px-2 py-0.5 rounded bg-sky-100 text-sky-800 text-[10px] font-bold">Compra semanal</span>`
                        : `<span class="px-2 py-0.5 rounded bg-emerald-100 text-emerald-800 text-[10px] font-bold">${item.durationNote}</span>`
                    }
                  </div>
                  <div class="text-sm font-extrabold ${isChecked ? "line-through text-slate-400" : "text-slate-900"}">${item.name}</div>
                  <div class="text-xs font-bold text-emerald-700">${item.quantity}</div>
                </div>
                <div class="text-right shrink-0">
                  <div class="px-2.5 py-1 rounded-lg bg-slate-100 border border-slate-200 text-xs font-extrabold text-slate-900">
                    S/ ${item.priceSoles.toFixed(2)}
                  </div>
                  <div class="text-[11px] text-slate-500 mt-0.5">S/ ${item.weeklyCostSoles.toFixed(2)}/sem</div>
                </div>
              </div>
              <div class="text-xs text-slate-600">Plan: ${item.usageNote}</div>
            </div>
          </div>`;
        })
        .join("");

      groupsHtml += `
        <div class="bg-white rounded-2xl border border-slate-200 shadow-sm overflow-hidden">
          <div class="bg-slate-900 text-white px-4 py-3 flex items-center justify-between">
            <div>
              <div class="text-sm font-extrabold">${cat.sectionHeader}</div>
              <div class="text-[11px] text-emerald-300">
                ${catChecked}/${list.length} marcados • Caja S/ ${catTotal.toFixed(2)} • Semanal S/ ${catWeekly.toFixed(2)}
              </div>
            </div>
            <button onclick="APP.toggleShopCatAll('${code}')"
              class="px-2.5 py-1 rounded-lg bg-white/10 hover:bg-white/20 text-emerald-300 text-xs font-bold">
              Marcar sección
            </button>
          </div>
          <div>${rowsHtml}</div>
        </div>`;
    });

    if (!groupsHtml) {
      groupsHtml = `
        <div class="bg-white rounded-2xl border border-slate-200 p-8 text-center text-slate-500 text-sm">
          No hay insumos que coincidan con el filtro actual.
        </div>`;
    }

    const portionGuidesHtml = DATA.portionGuides
      .map(
        (g) => `
      <div class="p-3 rounded-xl bg-emerald-50/60 border border-emerald-200 space-y-1">
        <div class="flex items-center justify-between gap-2">
          <span class="text-xs font-extrabold text-emerald-950">${g.agoraProduct}</span>
          <span class="text-xs font-extrabold text-emerald-700">${g.priceText}</span>
        </div>
        <div class="text-[11px] font-bold text-slate-800">Plan semanal: ${g.doctorRequest}</div>
        <div class="text-xs text-slate-600">En casa: ${g.homeInstruction}</div>
      </div>`
      )
      .join("");

    return `
      <div class="space-y-4">
        <!-- Hero Financiero Agora -->
        <div class="bg-gradient-to-br from-amber-50 via-white to-emerald-50 rounded-2xl border border-amber-300/70 p-4 shadow-sm space-y-3">
          <div class="inline-flex items-center gap-1.5 px-3 py-1 rounded-full bg-amber-100 text-amber-800 text-[11px] font-extrabold">
            🏪 PLAZA VEA VÍA AGORA • 28 SKUs (35 ÍTEMS VERIFICADOS)
          </div>
          <div>
            <h2 class="text-base font-extrabold text-slate-900">Lista de Compras Real — Plaza Vea vía Agora</h2>
            <p class="text-xs text-slate-600">Precios y presentaciones auditadas en Agora. Los empaques grandes de pavita, pescado, hígado, lomo y abarrotes rinden varias semanas.</p>
          </div>

          <div class="grid grid-cols-3 gap-2">
            <div class="p-2.5 rounded-xl bg-amber-50 border border-amber-200 text-center">
              <div class="text-[10px] font-bold text-slate-500">SEMANA 1 (CAJA)</div>
              <div class="text-sm font-extrabold text-amber-800">S/ ${DATA.financials.week1Total.toFixed(2)}</div>
              <div class="text-[10px] text-slate-500">28 SKUs completos</div>
            </div>
            <div class="p-2.5 rounded-xl bg-sky-50 border border-sky-200 text-center">
              <div class="text-[10px] font-bold text-slate-500">SEMANAS 2–4</div>
              <div class="text-sm font-extrabold text-sky-800">S/ ${DATA.financials.weeklyReplenishment.toFixed(2)}</div>
              <div class="text-[10px] text-slate-500">Reposición frescos</div>
            </div>
            <div class="p-2.5 rounded-xl bg-emerald-50 border border-emerald-200 text-center">
              <div class="text-[10px] font-bold text-slate-500">COSTO NETO/SEM</div>
              <div class="text-sm font-extrabold text-emerald-800">S/ ${DATA.financials.netWeeklyConsumed.toFixed(2)}</div>
              <div class="text-[10px] text-slate-500">Prorrateado real</div>
            </div>
          </div>

          <div class="bg-white rounded-xl border border-slate-200 p-3 space-y-2">
            <div class="flex items-center justify-between text-xs">
              <span class="font-bold text-slate-700">En tu carrito Agora (${checkedCount}/${totalCount} ítems):</span>
              <span class="font-extrabold text-emerald-700">S/ ${checkedSoles.toFixed(2)} / S/ ${DATA.financials.week1Total.toFixed(2)}</span>
            </div>
            <div class="w-full h-2.5 rounded-full bg-slate-100 overflow-hidden">
              <div class="h-full bg-emerald-600 transition-all duration-300" style="width:${pct}%"></div>
            </div>
            <div class="flex items-center justify-between text-[11px] text-slate-500">
              <span>Pendiente por comprar: S/ ${pendingSoles.toFixed(2)}</span>
              <span class="font-bold text-emerald-700">${pct}% listo</span>
            </div>
          </div>

          <div class="flex flex-wrap gap-2">
            <button onclick="APP.copyKeepList()"
              class="flex-1 py-2.5 px-4 rounded-xl bg-slate-900 hover:bg-slate-800 text-white text-xs font-extrabold transition">
              📋 Copiar Lista para Google Keep
            </button>
            <button onclick="APP.clearAllShop()"
              class="py-2.5 px-4 rounded-xl bg-rose-50 hover:bg-rose-100 text-rose-700 border border-rose-200 text-xs font-extrabold transition">
              🔄 Desmarcar Todo
            </button>
          </div>

          <label class="flex items-center justify-between px-3 py-2 rounded-xl bg-white/80 border border-slate-200/80 cursor-pointer text-xs font-semibold text-slate-700">
            <span>Ocultar insumos ya marcados en carrito</span>
            <input type="checkbox" ${state.hideCheckedShop ? "checked" : ""} onchange="APP.toggleHideCheckedShop()" class="w-4 h-4 accent-emerald-600" />
          </label>
        </div>

        <!-- Guía de Fraccionamiento en Casa (Tabla 1 Agora) -->
        <div class="bg-white rounded-2xl border border-emerald-300 shadow-sm overflow-hidden">
          <button onclick="APP.togglePortionGuide()"
            class="w-full px-4 py-3 flex items-center justify-between text-left hover:bg-emerald-50/40 transition">
            <div>
              <div class="text-sm font-extrabold text-slate-900">✂️ Guía de Fraccionamiento en Casa (Tabla 1 Agora)</div>
              <div class="text-xs text-slate-500">Cómo porcionar y congelar carnes, pescado, hígado y queso comprados en Agora</div>
            </div>
            <span class="text-xs font-extrabold text-emerald-700">${state.showPortionGuide ? "Ocultar ▲" : "Ver Guía ▼"}</span>
          </button>
          ${state.showPortionGuide ? `<div class="p-4 pt-2 border-t border-slate-100 grid sm:grid-cols-2 gap-2.5">${portionGuidesHtml}</div>` : ""}
        </div>

        <!-- Buscador y Categorías -->
        <div class="space-y-2">
          <input type="search" value="${state.shopSearch.replace(/"/g, "&quot;")}"
            oninput="APP.setShopSearch(this.value)"
            placeholder="Filtrar SKU Agora (ej. pollo, sadia, basa, bell's, fresa, palta)…"
            class="w-full px-4 py-2.5 rounded-2xl bg-white border border-slate-200 text-sm focus:outline-none focus:border-emerald-600 shadow-sm" />
          <div class="flex gap-1.5 overflow-x-auto pb-1">${catChipsHtml}</div>
        </div>

        <!-- Grupos de Compras -->
        <div class="space-y-4">${groupsHtml}</div>
      </div>
    `;
  }

  function renderHealthTab() {
    const selectedDay = DATA.days[state.selectedDayIndex] || DATA.days[0];
    const health = getDayHealth(state.selectedDayIndex);
    const waterGlasses = health.waterGlasses || 0;
    const liters = (waterGlasses * 0.25).toFixed(2);
    const waterPct = Math.min(100, Math.round((waterGlasses / 13) * 100));

    const startW = 123.0;
    const goalW = 81.0;
    const lostKg = Math.max(0, startW - state.currentWeightKg);
    const remKg = Math.max(0, state.currentWeightKg - goalW);
    const weightPct = Math.max(0, Math.min(100, Math.round(((startW - state.currentWeightKg) / (startW - goalW)) * 100)));

    let glassesHtml = "";
    for (let g = 1; g <= 13; g++) {
      const active = g <= waterGlasses;
      glassesHtml += `
        <button onclick="APP.setWaterGlass(${state.selectedDayIndex}, ${g})"
          class="h-11 rounded-xl border text-xs font-extrabold flex flex-col items-center justify-center transition ${
            active
              ? "bg-sky-600 border-sky-700 text-white shadow-sm"
              : "bg-slate-50 border-slate-200 text-slate-600 hover:bg-sky-50"
          }">
          <span>💧</span>
          <span class="text-[10px]">${g}</span>
        </button>`;
    }

    const biomarkersHtml = DATA.biomarkers
      .map((b) => {
        const val = state.customBiomarkers[b.id] || b.defaultValueText;
        const toneMap = {
          amber: "bg-amber-50 border-amber-200 text-amber-800",
          rose: "bg-rose-50 border-rose-200 text-rose-800",
          sky: "bg-sky-50 border-sky-200 text-sky-800",
          emerald: "bg-emerald-50 border-emerald-200 text-emerald-800"
        };
        return `
        <div onclick="APP.promptBiomarker('${b.id}')"
          class="p-3.5 rounded-2xl border cursor-pointer hover:shadow-sm transition ${toneMap[b.tone] || toneMap.emerald}">
          <div class="flex items-center justify-between text-[11px] font-extrabold uppercase">
            <span>${b.label}</span>
            <span>✎</span>
          </div>
          <div class="mt-1 flex items-baseline gap-1.5">
            <span class="text-xl font-extrabold text-slate-900">${val}</span>
            <span class="text-xs text-slate-600 font-semibold">${b.subUnit}</span>
          </div>
          <div class="text-[11px] font-bold text-emerald-700 mt-0.5">${b.targetText}</div>
        </div>`;
      })
      .join("");

    const rulesHtml = DATA.goldenRules
      .map(
        (r) => `
      <div class="p-3.5 rounded-xl bg-slate-50 border border-slate-200 space-y-1">
        <div class="text-xs font-extrabold text-emerald-800">${r.title}</div>
        <p class="text-xs text-slate-600 leading-relaxed">${r.detail}</p>
      </div>`
      )
      .join("");

    return `
      <div class="space-y-4">
        <!-- Evolución de Peso Corporal (123 -> 81 kg) -->
        <div class="bg-white rounded-2xl border border-emerald-300 p-4 shadow-sm space-y-3">
          <div class="flex items-center justify-between gap-2">
            <div>
              <h3 class="text-base font-extrabold text-slate-900">⚖️ Evolución de Peso Corporal</h3>
              <p class="text-xs text-slate-500">Inicial: 123.0 kg • Meta clínica: 81.0 kg</p>
            </div>
            <button onclick="APP.promptWeight()"
              class="px-3.5 py-2 rounded-xl bg-emerald-700 hover:bg-emerald-800 text-white text-xs font-extrabold shadow-sm transition">
              ✎ ${state.currentWeightKg.toFixed(1)} kg
            </button>
          </div>
          <div class="w-full h-2.5 rounded-full bg-emerald-100 overflow-hidden">
            <div class="h-full bg-emerald-600 transition-all duration-300" style="width:${weightPct}%"></div>
          </div>
          <div class="flex items-center justify-between text-xs">
            <span class="font-extrabold text-emerald-700">Bajado: -${lostKg.toFixed(1)} kg (${weightPct}%)</span>
            <div class="flex items-center gap-1.5">
              <span class="text-slate-500">Faltan ${remKg.toFixed(1)} kg</span>
              <button onclick="APP.stepWeight(-0.5)" class="px-2 py-1 rounded-lg bg-emerald-50 border border-emerald-300 text-emerald-900 font-bold">-0.5 kg</button>
              <button onclick="APP.stepWeight(0.5)" class="px-2 py-1 rounded-lg bg-slate-100 border border-slate-300 text-slate-700 font-bold">+0.5 kg</button>
            </div>
          </div>
        </div>

        <!-- Hidratación Renal 13 Vasos (3.25 L) -->
        <div class="bg-white rounded-2xl border border-slate-200 p-4 shadow-sm space-y-3">
          <div class="flex items-center justify-between">
            <div>
              <h3 class="text-base font-extrabold text-slate-900">💧 Hidratación Renal (${selectedDay.dayName})</h3>
              <p class="text-xs text-slate-500">Meta: 13 vasos de 250 ml = 3.25 Litros</p>
            </div>
            <div class="text-right">
              <div class="text-lg font-extrabold text-sky-700">${liters} L</div>
              <div class="text-[11px] text-slate-500">${waterGlasses} / 13 vasos</div>
            </div>
          </div>
          <div class="w-full h-2 rounded-full bg-sky-100 overflow-hidden">
            <div class="h-full bg-sky-600 transition-all duration-300" style="width:${waterPct}%"></div>
          </div>
          <div class="grid grid-cols-7 gap-1.5">${glassesHtml}</div>
          <div class="p-3 rounded-xl bg-sky-50 border border-sky-200 text-xs text-sky-950">
            Por qué 3.25 L: Diluye tu creatinina urinaria (267 mg/dL), normaliza la microalbuminuria (27 mg/L) y arrastra el ácido úrico (6.65 mg/dL).
          </div>
        </div>

        <!-- 6 Marcadores Clínicos Editables -->
        <div class="bg-white rounded-2xl border border-slate-200 p-4 shadow-sm space-y-3">
          <div>
            <h3 class="text-base font-extrabold text-slate-900">🩺 Tus Marcadores Clínicos y Metas</h3>
            <p class="text-xs text-slate-500">Haz clic en cualquier tarjeta para actualizar tus resultados de laboratorio</p>
          </div>
          <div class="grid sm:grid-cols-2 gap-2.5">${biomarkersHtml}</div>
        </div>

        <!-- 4 Reglas Clínicas de Oro -->
        <div class="bg-white rounded-2xl border border-slate-200 p-4 shadow-sm space-y-3">
          <h3 class="text-base font-extrabold text-slate-900">🛡️ 4 Reglas Clínicas de Oro del Plan</h3>
          <div class="space-y-2">${rulesHtml}</div>
          <div class="pt-2 border-t border-slate-100 flex items-center justify-between">
            <span class="text-xs text-slate-500">Reiniciar marcas al iniciar nueva semana:</span>
            <button onclick="APP.resetWeek()"
              class="px-3.5 py-2 rounded-xl bg-rose-50 hover:bg-rose-100 text-rose-700 border border-rose-200 text-xs font-extrabold">
              🔄 Reiniciar Semana
            </button>
          </div>
        </div>
      </div>
    `;
  }

  function renderModal() {
    const root = document.getElementById("recipe-modal-root");
    if (!root) return;
    if (!state.modalMealId) {
      root.innerHTML = "";
      return;
    }
    const meal = allMealsFlat().find((m) => m.id === state.modalMealId);
    if (!meal) {
      root.innerHTML = "";
      return;
    }
    const isDone = state.completedMeals.has(meal.id);

    let timerSectionHtml = "";
    if (meal.timers && meal.timers.length > 0) {
      const activeSpec = meal.timers[state.activeTimerIdx] || meal.timers[0];
      const pct = state.timerTotal > 0 ? Math.max(0, Math.min(100, (state.timerRemaining / state.timerTotal) * 100)) : 0;
      const timerChips =
        meal.timers.length > 1
          ? `<div class="flex gap-1.5 overflow-x-auto pb-1">
              ${meal.timers
                .map(
                  (t, idx) => `
                <button onclick="APP.selectModalTimer(${idx})"
                  class="px-2.5 py-1 rounded-lg text-xs font-bold whitespace-nowrap ${
                    idx === state.activeTimerIdx ? "bg-sky-700 text-white" : "bg-white text-slate-700 border border-sky-200"
                  }">
                  ${t.label}
                </button>`
                )
                .join("")}
            </div>`
          : `<div class="text-xs font-semibold text-sky-950">${activeSpec.label}</div>`;

      timerSectionHtml = `
        <div class="p-3.5 rounded-2xl bg-sky-50 border border-sky-200 space-y-2.5">
          <div class="text-xs font-extrabold text-sky-800 uppercase">⏱ Cronómetro Clínico y de Cocción</div>
          ${timerChips}
          <div class="flex items-center justify-between">
            <div>
              <div id="modal-timer-clock" class="text-2xl font-extrabold text-slate-900">
                ${state.timerRemaining <= 0 ? "¡Tiempo cumplido!" : formatTime(state.timerRemaining)}
              </div>
              <div class="text-[11px] text-slate-500">${state.timerRunning ? "Contando en vivo…" : "Listo para iniciar"}</div>
            </div>
            <div class="flex gap-2">
              <button onclick="APP.toggleTimerRun()"
                class="px-3.5 py-2 rounded-xl text-white text-xs font-extrabold ${
                  state.timerRunning ? "bg-amber-600 hover:bg-amber-700" : "bg-sky-700 hover:bg-sky-800"
                }">
                ${state.timerRunning ? "⏸ Pausar" : "▶ Iniciar"}
              </button>
              <button onclick="APP.resetTimer()"
                class="px-3 py-2 rounded-xl bg-white border border-sky-300 text-sky-800 text-xs font-bold">
                ↺
              </button>
            </div>
          </div>
          <div class="w-full h-1.5 rounded-full bg-white overflow-hidden">
            <div id="modal-timer-bar" class="h-full bg-sky-600 transition-all duration-300" style="width:${pct}%"></div>
          </div>
        </div>`;
    }

    const ingsHtml = meal.ingredients
      .map((ing, idx) => {
        const key = `${meal.id}_${idx}`;
        const checked = state.checkedIngKeys.has(key);
        return `
        <label onclick="APP.toggleIngredient('${meal.id}', ${idx})"
          class="p-2.5 rounded-xl border flex items-center gap-2.5 cursor-pointer text-xs ${
            checked ? "bg-emerald-50/70 border-emerald-300 line-through text-slate-400" : "bg-slate-50 border-slate-200 text-slate-800"
          }">
          <input type="checkbox" ${checked ? "checked" : ""} onclick="event.stopPropagation(); APP.toggleIngredient('${meal.id}', ${idx})" class="w-4 h-4 accent-emerald-600" />
          <span class="flex-1">${ing}</span>
        </label>`;
      })
      .join("");

    const stepsHtml = meal.steps
      .map(
        (step, idx) => `
      <div class="p-3 rounded-xl bg-white border border-slate-200 flex items-start gap-2.5 text-xs">
        <span class="w-5 h-5 rounded-full bg-slate-900 text-white font-bold flex items-center justify-center shrink-0 text-[11px]">${idx + 1}</span>
        <span class="text-slate-800 leading-relaxed">${step}</span>
      </div>`
      )
      .join("");

    root.innerHTML = `
      <div onclick="APP.closeRecipe()" class="fixed inset-0 z-50 bg-slate-950/60 backdrop-blur-xs flex items-end sm:items-center justify-center p-0 sm:p-4">
        <div onclick="event.stopPropagation()" class="bg-white w-full max-w-xl rounded-t-3xl sm:rounded-3xl max-h-[90vh] flex flex-col overflow-hidden shadow-2xl">
          <!-- Modal Header -->
          <div class="bg-gradient-to-r from-slate-900 to-emerald-950 p-4 text-white space-y-2.5">
            <div class="flex items-start justify-between gap-2">
              <div class="flex flex-wrap gap-1.5">
                <span class="px-2.5 py-0.5 rounded-full bg-emerald-500/25 text-emerald-300 text-[11px] font-bold">
                  ${meal.dayName.toUpperCase()} • OPCIÓN ${meal.dayIndex + 1}
                </span>
                <span class="px-2.5 py-0.5 rounded-full bg-white/15 text-white text-[11px] font-bold">
                  ${meal.time} • ${meal.slotLabel}
                </span>
              </div>
              <button onclick="APP.closeRecipe()" class="w-8 h-8 rounded-full bg-white/15 hover:bg-white/25 flex items-center justify-center text-sm">✕</button>
            </div>
            <h3 class="text-lg font-extrabold leading-snug">${meal.title}</h3>
            <p class="text-xs text-emerald-100/90">${meal.shortDesc}</p>
            <div class="grid grid-cols-5 gap-1 p-2 rounded-xl bg-slate-950/60 border border-white/10 text-center">
              <div><div class="text-[10px] text-white/70">KCAL</div><div class="text-xs font-extrabold">${meal.macros.kcal}</div></div>
              <div><div class="text-[10px] text-white/70">PROT</div><div class="text-xs font-extrabold text-emerald-300">${meal.macros.prot}g</div></div>
              <div><div class="text-[10px] text-white/70">CARBOS</div><div class="text-xs font-extrabold text-amber-400">${meal.macros.carb}g</div></div>
              <div><div class="text-[10px] text-white/70">GRASAS</div><div class="text-xs font-extrabold text-sky-400">${meal.macros.fat}g</div></div>
              <div><div class="text-[10px] text-white/70">FIBRA</div><div class="text-xs font-extrabold text-emerald-100">${meal.macros.fiber}g</div></div>
            </div>
          </div>

          <!-- Modal Body -->
          <div class="p-4 overflow-y-auto space-y-4 flex-1">
            ${timerSectionHtml}

            <div class="space-y-2">
              <div class="flex items-center justify-between">
                <span class="text-xs font-extrabold text-slate-900 uppercase">⚖️ Ingredientes Exactos (Marcables)</span>
                <button onclick="APP.copyRecipe()" class="text-xs font-bold text-emerald-700 hover:underline">📋 Copiar Receta</button>
              </div>
              <div class="space-y-1.5">${ingsHtml}</div>
            </div>

            <div class="space-y-2">
              <div class="text-xs font-extrabold text-slate-900 uppercase">📖 Receta Clínica Paso a Paso</div>
              <div class="space-y-1.5">${stepsHtml}</div>
            </div>

            <div class="p-3.5 rounded-2xl bg-emerald-50 border border-emerald-200 space-y-1">
              <div class="text-[11px] font-extrabold text-emerald-950 uppercase">🛡️ Protección Metabólica (Insulina 39.0 | Úrico 6.65)</div>
              <p class="text-xs text-slate-700 leading-relaxed">${meal.clinicalNote}</p>
            </div>
          </div>

          <!-- Modal Footer -->
          <div class="p-3 bg-slate-100 border-t border-slate-200 flex items-center gap-2">
            <button onclick="APP.navModal(-1)" class="w-10 h-10 rounded-xl bg-white border border-slate-300 font-bold">←</button>
            <button onclick="APP.navModal(1)" class="w-10 h-10 rounded-xl bg-white border border-slate-300 font-bold">→</button>
            <button onclick="APP.toggleMealDone('${meal.id}')"
              class="flex-1 py-2.5 px-4 rounded-xl font-extrabold text-xs transition ${
                isDone ? "bg-emerald-100 text-emerald-950" : "bg-emerald-600 text-white hover:bg-emerald-700"
              }">
              ${isDone ? "✓ Completada (Desmarcar)" : "✓ Marcar Comida Lista"}
            </button>
          </div>
        </div>
      </div>
    `;
  }

  function render() {
    renderHeader();
    const main = document.getElementById("main-tab-container");
    if (!main) return;
    if (state.activeTab === "plan") main.innerHTML = renderPlanTab();
    else if (state.activeTab === "shop") main.innerHTML = renderShopTab();
    else main.innerHTML = renderHealthTab();
  }

  document.addEventListener("DOMContentLoaded", () => {
    render();
  });
})();
