package com.library.strategy;

/**
 * STRATEGY PATTERN - Student fine calculation (LKR 50 per day)
 * Student ID: KU00298794
 */
public class KU00298794_StudentFineStrategy implements KU00298794_FineCalculationStrategy {
    private static final double FINE_RATE = 50.0;

    @Override
    public double calculateFine(int daysOverdue) {
        return daysOverdue * FINE_RATE;
    }

    @Override
    public double getFineRate() {
        return FINE_RATE;
    }
}
