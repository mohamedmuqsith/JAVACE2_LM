package com.library.strategy;

/**
 * STRATEGY PATTERN - Faculty fine calculation (LKR 20 per day)
 * Student ID: KU00298794
 */
public class KU00298794_FacultyFineStrategy implements KU00298794_FineCalculationStrategy {
    private static final double FINE_RATE = 20.0;

    @Override
    public double calculateFine(int daysOverdue) {
        return daysOverdue * FINE_RATE;
    }

    @Override
    public double getFineRate() {
        return FINE_RATE;
    }
}
