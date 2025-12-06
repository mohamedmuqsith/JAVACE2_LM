package com.library.service;

import com.library.KU00298794_Library;
import com.library.model.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Report service to generate various library reports
 * Student ID: KU00298794
 */
public class KU00298794_ReportService {
    private KU00298794_Library library;

    public KU00298794_ReportService(KU00298794_Library library) {
        this.library = library;
    }

    public List<KU00298794_Book> generateMostBorrowedBooks(int limit) {
        Map<KU00298794_Book, Integer> borrowCountMap = new HashMap<>();

        for (KU00298794_Book book : library.getAllBooks()) {
            borrowCountMap.put(book, book.getBorrowedHistory().size());
        }

        return borrowCountMap.entrySet().stream()
                .sorted(Map.Entry.<KU00298794_Book, Integer>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<KU00298794_User> generateActiveBorrowers(int limit) {
        Map<KU00298794_User, Integer> borrowCountMap = new HashMap<>();

        for (KU00298794_User user : library.getAllUsers()) {
            borrowCountMap.put(user, user.getBorrowedBooks().size());
        }

        return borrowCountMap.entrySet().stream()
                .sorted(Map.Entry.<KU00298794_User, Integer>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<KU00298794_BorrowRecord> generateOverdueBooks() {
        return library.getBorrowingService().checkOverdueBooks();
    }

    public double generateRevenueReport() {
        double totalRevenue = 0.0;

        for (KU00298794_Book book : library.getAllBooks()) {
            for (KU00298794_BorrowRecord record : book.getBorrowedHistory()) {
                totalRevenue += record.getFineAmount();
            }
        }

        return totalRevenue;
    }

    public void printMostBorrowedBooksReport(int limit) {
        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║              MOST BORROWED BOOKS REPORT                        ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");

        List<KU00298794_Book> topBooks = generateMostBorrowedBooks(limit);

        for (int i = 0; i < topBooks.size(); i++) {
            KU00298794_Book book = topBooks.get(i);
            int count = book.getBorrowedHistory().size();
            System.out.printf("%d. %s - %d times borrowed\n", i + 1, book.getTitle(), count);
        }
        System.out.println();
    }

    public void printActiveBorrowersReport(int limit) {
        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║               ACTIVE BORROWERS REPORT                          ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");

        List<KU00298794_User> topBorrowers = generateActiveBorrowers(limit);

        for (int i = 0; i < topBorrowers.size(); i++) {
            KU00298794_User user = topBorrowers.get(i);
            int count = user.getBorrowedBooks().size();
            System.out.printf("%d. %s (%s) - %d books currently borrowed\n",
                    i + 1, user.getName(), user.getMembershipType(), count);
        }
        System.out.println();
    }

    public void printOverdueBooksReport() {
        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                  OVERDUE BOOKS REPORT                          ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");

        List<KU00298794_BorrowRecord> overdueRecords = generateOverdueBooks();

        if (overdueRecords.isEmpty()) {
            System.out.println("  No overdue books!");
        } else {
            for (KU00298794_BorrowRecord record : overdueRecords) {
                System.out.printf("  • %s borrowed by %s\n",
                        record.getBook().getTitle(), record.getUser().getName());
                System.out.printf("    Overdue: %d days | Fine: LKR %.2f\n",
                        record.calculateOverdueDays(),
                        record.getUser().calculateFine(record.calculateOverdueDays()));
            }
        }
        System.out.println();
    }
}
