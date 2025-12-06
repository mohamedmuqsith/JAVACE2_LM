package com.library.model;

import com.library.strategy.KU00298794_FineCalculationStrategy;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract base class for all library users
 * Student ID: KU00298794
 */
public abstract class KU00298794_User {
    private String userId;
    private String name;
    private String email;
    private String contactNumber;
    private String membershipType;
    private List<KU00298794_BorrowRecord> borrowedBooks;
    private List<KU00298794_Transaction> transactionHistory;
    private KU00298794_FineCalculationStrategy fineStrategy;

    public KU00298794_User(String userId, String name, String email,
            String contactNumber, String membershipType,
            KU00298794_FineCalculationStrategy fineStrategy) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.membershipType = membershipType;
        this.borrowedBooks = new ArrayList<>();
        this.transactionHistory = new ArrayList<>();
        this.fineStrategy = fineStrategy;
    }

    public abstract int getBorrowingLimit();

    public abstract int getDueDays();

    public String getId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public List<KU00298794_BorrowRecord> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void addBorrowRecord(KU00298794_BorrowRecord record) {
        borrowedBooks.add(record);
    }

    public void removeBorrowRecord(KU00298794_BorrowRecord record) {
        borrowedBooks.remove(record);
    }

    public double calculateFine(int daysOverdue) {
        return fineStrategy.calculateFine(daysOverdue);
    }

    public void payFine(double amount) {
        KU00298794_Transaction transaction = new KU00298794_Transaction(
                "TXN-" + System.currentTimeMillis(), this, amount, "FINE_PAYMENT");
        transactionHistory.add(transaction);
        transaction.process();
    }

    public List<KU00298794_Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public KU00298794_FineCalculationStrategy getFineStrategy() {
        return fineStrategy;
    }

    @Override
    public String toString() {
        return String.format("User[ID=%s, Name=%s, Type=%s, Email=%s]",
                userId, name, membershipType, email);
    }
}
