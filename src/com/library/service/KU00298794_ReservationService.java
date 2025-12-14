package com.library.service;

import com.library.KU00298794_Library;
import com.library.model.*;
import com.library.observer.KU00298794_NotificationService;
import com.library.util.KU00298794_Logger;
import java.util.*;

/**
 * Reservation service to manage book reservations
 * Student ID: KU00298794
 */
public class KU00298794_ReservationService {
    private KU00298794_Library library;
    private KU00298794_NotificationService notificationService;
    private Map<String, List<KU00298794_Reservation>> reservations;

    public KU00298794_ReservationService(KU00298794_Library library,
            KU00298794_NotificationService notificationService) {
        this.library = library;
        this.notificationService = notificationService;
        this.reservations = new HashMap<>();
    }

    public boolean reserveBook(KU00298794_User user, KU00298794_Book book) {
        if (book.reserve(user)) {
            String bookId = book.getBookId();
            reservations.putIfAbsent(bookId, new ArrayList<>());

            reservations.get(bookId).add(new KU00298794_Reservation(
                    "RES-" + System.currentTimeMillis(), user, book));

            System.out.println("✓ Book reserved successfully by " + user.getName());

            // Log event
            KU00298794_Logger.getInstance().logReservation(user.getId(), book.getBookId());

            return true;
        }

        System.out.println("❌ Failed to reserve book.");
        return false;
    }

    public boolean cancelReservation(KU00298794_User user, KU00298794_Book book) {
        String bookId = book.getBookId();
        List<KU00298794_Reservation> resList = reservations.get(bookId);

        if (resList != null) {
            boolean removed = resList.removeIf(r -> r.getUser().getId().equals(user.getId()));

            if (removed) {
                // Also remove from book's reservation queue
                book.getReservationQueue().removeIf(r -> r.getUser().getId().equals(user.getId()));

                System.out.println("✓ Reservation cancelled for " + user.getName());
                return true;
            }
        }

        System.out.println("❌ No reservation found for this user.");
        return false;
    }

    public void processReturnedBook(KU00298794_Book book) {
        KU00298794_User nextReserver = book.getNextReserver();

        if (nextReserver != null) {
            System.out.println("📢 Notifying next reserver: " + nextReserver.getName());
            notificationService.notifyReservationAvailable(nextReserver, book);
        }
    }

    public KU00298794_User getNextReserver(KU00298794_Book book) {
        KU00298794_Reservation res = book.getReservationQueue().peek();
        return res != null ? res.getUser() : null;
    }

    public Map<String, List<KU00298794_Reservation>> getReservations() {
        return reservations;
    }
}
