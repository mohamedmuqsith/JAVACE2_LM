package com.library.observer;

import com.library.model.KU00298794_User;
import com.library.model.KU00298794_Book;
import java.util.ArrayList;
import java.util.List;

/**
 * OBSERVER PATTERN - NotificationService (Subject) manages and notifies
 * observers
 * Student ID: KU00298794
 */
public class KU00298794_NotificationService {
    private List<KU00298794_Observer> observers;

    public KU00298794_NotificationService() {
        this.observers = new ArrayList<>();
    }

    public void attach(KU00298794_Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            System.out.println("Observer attached: " + observer.getObserverId());
        }
    }

    public void detach(KU00298794_Observer observer) {
        observers.remove(observer);
        System.out.println("Observer detached: " + observer.getObserverId());
    }

    public void notifyObservers(String message) {
        for (KU00298794_Observer observer : observers) {
            observer.update(message);
        }
    }

    public void notifyDueDateReminder(KU00298794_User user, KU00298794_Book book) {
        String message = String.format("[DUE DATE REMINDER] Dear %s, the book '%s' is due soon. Please return on time.",
                user.getName(), book.getTitle());
        notifyObserversByUser(user, message);
    }

    public void notifyOverdue(KU00298794_User user, KU00298794_Book book, double fine) {
        String message = String.format("[OVERDUE NOTICE] Dear %s, the book '%s' is overdue. Fine: LKR %.2f",
                user.getName(), book.getTitle(), fine);
        notifyObserversByUser(user, message);
    }

    public void notifyReservationAvailable(KU00298794_User user, KU00298794_Book book) {
        String message = String.format(
                "[RESERVATION AVAILABLE] Dear %s, your reserved book '%s' is now available for pickup!",
                user.getName(), book.getTitle());
        notifyObserversByUser(user, message);
    }

    private void notifyObserversByUser(KU00298794_User user, String message) {
        for (KU00298794_Observer observer : observers) {
            if (observer.getObserverId().contains(user.getId())) {
                observer.update(message);
            }
        }
    }
}
