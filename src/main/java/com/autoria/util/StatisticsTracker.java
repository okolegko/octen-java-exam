package com.autoria.util;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * Утиліта для підрахунку переглядів оголошень у пам’яті.
 * Потокобезпечна, працює через ConcurrentHashMap і AtomicInteger.
 */
@Component
public class StatisticsTracker {

    // Карта <ID оголошення, кількість переглядів>
    private final Map<Long, AtomicInteger> viewCounts = new ConcurrentHashMap<>();

    /*
     * Збільшує лічильник переглядів для певного оголошення.
     *
     * @param listingId ID оголошення
     */
    public void incrementViews(Long listingId) {
        viewCounts.computeIfAbsent(listingId, id -> new AtomicInteger(0)).incrementAndGet();
    }

    /*
     * Повертає кількість переглядів для конкретного оголошення.
     *
     * @param listingId ID оголошення
     * @return кількість переглядів
     */
    public int getViews(Long listingId) {
        return viewCounts.getOrDefault(listingId, new AtomicInteger(0)).get();
    }

    /*
     * Очистити всі статистичні дані (не обов’язковий метод).
     */
    public void resetAll() {
        viewCounts.clear();
    }
}
