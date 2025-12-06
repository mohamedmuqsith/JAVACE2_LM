package com.library.strategy;

/**
 * STRATEGY PATTERN - Interface for fine calculation strategies
 * Student ID: KU00298794
 */
public interface KU00298794_FineCalculationStrategy {
    double calculateFine(int daysOverdue);

    double getFineRate();
}
