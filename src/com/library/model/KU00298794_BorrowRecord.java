package com.library.model;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Borrow record to track book borrowing details
 * Student ID: KU00298794
 */
public class KU00298794_BorrowRecord {
    private KU00298794_User user;
    private KU00298794_Book book;
    private Date borrowDate;
    private Date dueDate;
    private Date returnDate;
    private double fineAmount;

    public KU00298794_BorrowRecord(KU00298794_User user, KU00298794_Book book,
            Date borrowDate, Date dueDate) {
        this.user = user;
        this.book = book;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = null;
        this.fineAmount = 0.0;
    }

    public KU00298794_User getUser() {
        return user;
    }

    public KU00298794_Book getBook() {
        return book;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }

    public boolean isOverdue() {
        Date checkDate = (returnDate != null) ? returnDate : new Date();
        return checkDate.after(dueDate);
    }

    public int calculateOverdueDays() {
        if (!isOverdue()) {
            return 0;
        }
        Date checkDate = (returnDate != null) ? returnDate : new Date();
        long diffInMillis = checkDate.getTime() - dueDate.getTime();
        return (int) TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
    }

    @Override
    public String toString() {
        return String.format("BorrowRecord[User=%s, Book=%s, BorrowDate=%s, DueDate=%s, Returned=%s, Fine=LKR %.2f]",
                user.getName(), book.getTitle(), borrowDate, dueDate,
                (returnDate != null ? "Yes" : "No"), fineAmount);
    }
}
