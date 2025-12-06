package com.library;

import com.library.model.*;
import com.library.service.*;
import com.library.observer.KU00298794_NotificationService;
import com.library.command.KU00298794_CommandInvoker;
import java.util.*;

/**
 * Main Library class - Central management of the library system
 * Student ID: KU00298794
 */
public class KU00298794_Library {
    private Map<String, KU00298794_Book> books;
    private Map<String, KU00298794_User> users;
    private Map<String, KU00298794_Librarian> librarians;
    private KU00298794_BorrowingService borrowingService;
    private KU00298794_ReservationService reservationService;
    private KU00298794_ReportService reportService;
    private KU00298794_NotificationService notificationService;
    private KU00298794_CommandInvoker commandInvoker;

    public KU00298794_Library() {
        this.books = new HashMap<>();
        this.users = new HashMap<>();
        this.librarians = new HashMap<>();
        this.notificationService = new KU00298794_NotificationService();
        this.borrowingService = new KU00298794_BorrowingService(this, notificationService);
        this.reservationService = new KU00298794_ReservationService(this, notificationService);
        this.reportService = new KU00298794_ReportService(this);
        this.commandInvoker = new KU00298794_CommandInvoker();
    }

    // Book Management
    public void addBook(KU00298794_Book book) {
        books.put(book.getBookId(), book);
        System.out.println("✓ Book added: " + book.getTitle());
    }

    public void removeBook(String bookId) {
        KU00298794_Book removed = books.remove(bookId);
        if (removed != null) {
            System.out.println("✓ Book removed: " + removed.getTitle());
        } else {
            System.out.println("❌ Book not found with ID: " + bookId);
        }
    }

    public KU00298794_Book getBook(String bookId) {
        return books.get(bookId);
    }

    public List<KU00298794_Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public List<KU00298794_Book> searchBooks(String query) {
        List<KU00298794_Book> results = new ArrayList<>();
        String lowerQuery = query.toLowerCase();

        for (KU00298794_Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(lowerQuery) ||
                    book.getAuthor().toLowerCase().contains(lowerQuery) ||
                    book.getCategory().toLowerCase().contains(lowerQuery) ||
                    book.getIsbn().contains(query)) {
                results.add(book);
            }
        }

        return results;
    }

    // User Management
    public void addUser(KU00298794_User user) {
        users.put(user.getId(), user);
        System.out.println("✓ User registered: " + user.getName());
    }

    public void removeUser(String userId) {
        KU00298794_User removed = users.remove(userId);
        if (removed != null) {
            System.out.println("✓ User removed: " + removed.getName());
        } else {
            System.out.println("❌ User not found with ID: " + userId);
        }
    }

    public KU00298794_User getUser(String userId) {
        return users.get(userId);
    }

    public List<KU00298794_User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    // Librarian Management
    public void addLibrarian(KU00298794_Librarian librarian) {
        librarians.put(librarian.getLibrarianId(), librarian);
        System.out.println("✓ Librarian added: " + librarian.getName());
    }

    public KU00298794_Librarian getLibrarian(String librarianId) {
        return librarians.get(librarianId);
    }

    // Service Getters
    public KU00298794_BorrowingService getBorrowingService() {
        return borrowingService;
    }

    public KU00298794_ReservationService getReservationService() {
        return reservationService;
    }

    public KU00298794_ReportService getReportService() {
        return reportService;
    }

    public KU00298794_NotificationService getNotificationService() {
        return notificationService;
    }

    public KU00298794_CommandInvoker getCommandInvoker() {
        return commandInvoker;
    }
}
