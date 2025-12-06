package com.library.service;

import com.library.KU00298794_Library;
import com.library.model.*;
import com.library.observer.KU00298794_NotificationService;
import java.util.*;

/**
 * Borrowing service to manage book borrowing and returning
 * Student ID: KU00298794
 */
public class KU00298794_BorrowingService {
    private KU00298794_Library library;
    private KU00298794_NotificationService notificationService;
    private Map<String, KU00298794_BorrowRecord> activeBorrowings;

    public KU00298794_BorrowingService(KU00298794_Library library,
            KU00298794_NotificationService notificationService) {
        this.library = library;
        this.notificationService = notificationService;
        this.activeBorrowings = new HashMap<>();
    }

    public boolean borrowBook(KU00298794_User user, KU00298794_Book book) {
        // Check if user has reached borrowing limit
        if (user.getBorrowedBooks().size() >= user.getBorrowingLimit()) {
            System.out.println("❌ Borrowing limit reached for " + user.getName());
            return false;
        }

        // Use State pattern to attempt borrowing
        if (book.borrow(user)) {
            Date borrowDate = new Date();
            Date dueDate = calculateDueDate(user, borrowDate);

            KU00298794_BorrowRecord record = new KU00298794_BorrowRecord(user, book, borrowDate, dueDate);

            user.addBorrowRecord(record);
            book.addBorrowRecord(record);
            activeBorrowings.put(generateKey(user, book), record);

            System.out.println("✓ Book borrowed successfully!");
            System.out.println("  Due Date: " + dueDate);

            return true;
        }

        return false;
    }

    public boolean returnBook(KU00298794_User user, KU00298794_Book book) {
        String key = generateKey(user, book);
        KU00298794_BorrowRecord record = activeBorrowings.get(key);

        if (record == null) {
            System.out.println("❌ No active borrow record found.");
            return false;
        }

        if (book.returnBook()) {
            record.setReturnDate(new Date());

            // Calculate fine if overdue
            if (record.isOverdue()) {
                int overdueDays = record.calculateOverdueDays();
                double fine = calculateFine(record);
                record.setFineAmount(fine);

                System.out.println("⚠ Book returned late!");
                System.out.println("  Overdue days: " + overdueDays);
                System.out.println("  Fine: LKR " + String.format("%.2f", fine));

                // Notify user about fine
                notificationService.notifyOverdue(user, book, fine);
            } else {
                System.out.println("✓ Book returned on time!");
            }

            user.removeBorrowRecord(record);
            activeBorrowings.remove(key);

            // Check if book was reserved and notify next reserver
            KU00298794_Reservation res = book.getReservationQueue().peek();
            KU00298794_User nextReserver = res != null ? res.getUser() : null;
            if (nextReserver != null) {
                notificationService.notifyReservationAvailable(nextReserver, book);
            }

            return true;
        }

        return false;
    }

    public Date calculateDueDate(KU00298794_User user, Date borrowDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(borrowDate);
        calendar.add(Calendar.DAY_OF_MONTH, user.getDueDays());
        return calendar.getTime();
    }

    public double calculateFine(KU00298794_BorrowRecord record) {
        int overdueDays = record.calculateOverdueDays();
        return record.getUser().calculateFine(overdueDays);
    }

    public List<KU00298794_BorrowRecord> checkOverdueBooks() {
        List<KU00298794_BorrowRecord> overdueRecords = new ArrayList<>();
        Date today = new Date();

        for (KU00298794_BorrowRecord record : activeBorrowings.values()) {
            if (today.after(record.getDueDate())) {
                overdueRecords.add(record);
            }
        }

        return overdueRecords;
    }

    public Map<String, KU00298794_BorrowRecord> getActiveBorrowings() {
        return activeBorrowings;
    }

    private String generateKey(KU00298794_User user, KU00298794_Book book) {
        return user.getId() + "_" + book.getBookId();
    }
}
