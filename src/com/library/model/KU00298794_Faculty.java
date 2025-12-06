package com.library.model;

import com.library.strategy.KU00298794_FacultyFineStrategy;

/**
 * Faculty user type - 30 days borrowing, 5 books limit
 * Student ID: KU00298794
 */
public class KU00298794_Faculty extends KU00298794_User {
    private static final int BORROWING_LIMIT = 5;
    private static final int DUE_DAYS = 30;
    
    public KU00298794_Faculty(String userId, String name, String email, String contactNumber) {
        super(userId, name, email, contactNumber, "Faculty", new KU00298794_FacultyFineStrategy());
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
