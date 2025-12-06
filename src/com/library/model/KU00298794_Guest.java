package com.library.model;

import com.library.strategy.KU00298794_GuestFineStrategy;

/**
 * Guest user type - 7 days borrowing, 1 book limit
 * Student ID: KU00298794
 */
public class KU00298794_Guest extends KU00298794_User {
    private static final int BORROWING_LIMIT = 1;
    private static final int DUE_DAYS = 7;

    public KU00298794_Guest(String userId, String name, String email, String contactNumber) {
        super(userId, name, email, contactNumber, "Guest", new KU00298794_GuestFineStrategy());
    }

    @Override
    public int getBorrowingLimit() {
        return BORROWING_LIMIT;
    }

    @Override
    public int getDueDays() {
        return DUE_DAYS;
    }
}
