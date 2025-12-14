package com.library.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * KU00298794_Logger - Singleton Logger for the Smart Library Management System
 * 
 * This class implements the Singleton pattern to provide a centralized logging
 * mechanism for all library operations. It logs various system events
 * including:
 * - Book borrowings and returns
 * - Reservations
 * - Fine calculations
 * - User activities
 * - System notifications
 * 
 * @author KU00298794
 * @version 1.0
 */
public class KU00298794_Logger {

    // Singleton instance
    private static KU00298794_Logger instance;

    // Log storage
    private List<String> logs;

    // Date formatter for timestamps
    private SimpleDateFormat dateFormat;

    // Log levels
    public enum LogLevel {
        INFO,
        WARNING,
        ERROR,
        DEBUG
    }

    /**
     * Private constructor for Singleton pattern
     */
    private KU00298794_Logger() {
        this.logs = new ArrayList<>();
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * Get the singleton instance of Logger
     * 
     * @return The Logger instance
     */
    public static synchronized KU00298794_Logger getInstance() {
        if (instance == null) {
            instance = new KU00298794_Logger();
        }
        return instance;
    }

    /**
     * Log an INFO level message
     * 
     * @param message The message to log
     */
    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    /**
     * Log a WARNING level message
     * 
     * @param message The message to log
     */
    public void warning(String message) {
        log(LogLevel.WARNING, message);
    }

    /**
     * Log an ERROR level message
     * 
     * @param message The message to log
     */
    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    /**
     * Log a DEBUG level message
     * 
     * @param message The message to log
     */
    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    /**
     * Core logging method
     * 
     * @param level   The log level
     * @param message The message to log
     */
    private void log(LogLevel level, String message) {
        String timestamp = dateFormat.format(new Date());
        String logEntry = String.format("[%s] [%s] %s", timestamp, level, message);
        logs.add(logEntry);
        System.out.println(logEntry);
    }

    /**
     * Log a book borrowing event
     * 
     * @param userId User who borrowed the book
     * @param bookId Book that was borrowed
     */
    public void logBorrow(String userId, String bookId) {
        info(String.format("BORROW: User '%s' borrowed book '%s'", userId, bookId));
    }

    /**
     * Log a book return event
     * 
     * @param userId User who returned the book
     * @param bookId Book that was returned
     */
    public void logReturn(String userId, String bookId) {
        info(String.format("RETURN: User '%s' returned book '%s'", userId, bookId));
    }

    /**
     * Log a reservation event
     * 
     * @param userId User who made the reservation
     * @param bookId Book that was reserved
     */
    public void logReservation(String userId, String bookId) {
        info(String.format("RESERVATION: User '%s' reserved book '%s'", userId, bookId));
    }

    /**
     * Log a fine calculation event
     * 
     * @param userId User who owes the fine
     * @param amount Fine amount
     */
    public void logFine(String userId, double amount) {
        warning(String.format("FINE: User '%s' owes fine of Rs. %.2f", userId, amount));
    }

    /**
     * Log a fine payment event
     * 
     * @param userId User who paid the fine
     * @param amount Amount paid
     */
    public void logFinePayment(String userId, double amount) {
        info(String.format("PAYMENT: User '%s' paid fine of Rs. %.2f", userId, amount));
    }

    /**
     * Log a user registration event
     * 
     * @param userId         New user ID
     * @param membershipType Type of membership
     */
    public void logUserRegistration(String userId, String membershipType) {
        info(String.format("REGISTRATION: New user '%s' registered as '%s'", userId, membershipType));
    }

    /**
     * Log a book addition event
     * 
     * @param bookId Book ID
     * @param title  Book title
     */
    public void logBookAdded(String bookId, String title) {
        info(String.format("BOOK ADDED: '%s' - '%s'", bookId, title));
    }

    /**
     * Log a notification sent event
     * 
     * @param userId           User who received the notification
     * @param notificationType Type of notification
     */
    public void logNotification(String userId, String notificationType) {
        debug(String.format("NOTIFICATION: Sent '%s' notification to user '%s'", notificationType, userId));
    }

    /**
     * Log an overdue warning
     * 
     * @param userId      User with overdue book
     * @param bookId      Overdue book
     * @param daysOverdue Number of days overdue
     */
    public void logOverdue(String userId, String bookId, int daysOverdue) {
        warning(String.format("OVERDUE: User '%s' has book '%s' overdue by %d days", userId, bookId, daysOverdue));
    }

    /**
     * Get all logs
     * 
     * @return List of all log entries
     */
    public List<String> getAllLogs() {
        return new ArrayList<>(logs);
    }

    /**
     * Get recent logs
     * 
     * @param count Number of recent logs to retrieve
     * @return List of recent log entries
     */
    public List<String> getRecentLogs(int count) {
        int size = logs.size();
        if (count >= size) {
            return new ArrayList<>(logs);
        }
        return new ArrayList<>(logs.subList(size - count, size));
    }

    /**
     * Clear all logs
     */
    public void clearLogs() {
        logs.clear();
        info("Logs cleared");
    }

    /**
     * Get the count of log entries
     * 
     * @return Number of log entries
     */
    public int getLogCount() {
        return logs.size();
    }

    /**
     * Print all logs to console
     */
    public void printAllLogs() {
        System.out.println("\n========== SYSTEM LOGS ==========");
        for (String log : logs) {
            System.out.println(log);
        }
        System.out.println("==================================\n");
    }

    @Override
    public String toString() {
        return "KU00298794_Logger [logs=" + logs.size() + " entries]";
    }
}
