package com.library.strategy;

/**
 * STRATEGY PATTERN - Guest fine calculation (LKR 100 per day)
 * Student ID: KU00298794
 */
public class KU00298794_GuestFineStrategy implements KU00298794_FineCalculationStrategy {
    private static final double FINE_RATE = 100.0;

    @Override
    public double calculateFine(int daysOverdue) {
        return daysOverdue * FINE_RATE;
    }

    @Override
    public double getFineRate() {
        return FINE_RATE;
    }
}
