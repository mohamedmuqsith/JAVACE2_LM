package com.library.model;

import com.library.strategy.KU00298794_StudentFineStrategy;

/**
 * Student user type - 14 days borrowing, 3 books limit
 * Student ID: KU00298794
 */
public class KU00298794_Student extends KU00298794_User {
    private static final int BORROWING_LIMIT = 3;
    private static final int DUE_DAYS = 14;
    
    public KU00298794_Student(String userId, String name, String email, String contactNumber) {
        super(userId, name, email, contactNumber, "Student", new KU00298794_StudentFineStrategy());
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
