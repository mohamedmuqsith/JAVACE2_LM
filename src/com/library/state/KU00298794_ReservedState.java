package com.library.state;

import com.library.model.KU00298794_Book;
import com.library.model.KU00298794_User;

/**
 * STATE PATTERN - Reserved state (book is reserved for someone)
 * Student ID: KU00298794
 */
public class KU00298794_ReservedState implements KU00298794_BookState {

    @Override
    public boolean borrow(KU00298794_Book book, KU00298794_User user) {
        // Check if this user is the rightful reserver
        com.library.model.KU00298794_Reservation res = book.getReservationQueue().peek();
        KU00298794_User nextReserver = res != null ? res.getUser() : null;
        if (nextReserver != null && nextReserver.getId().equals(user.getId())) {
            System.out.println("Reserved book borrowed by " + user.getName());
            book.getNextReserver(); // Remove from queue
            book.setState(new KU00298794_BorrowedState());
            return true;
        } else {
            System.out.println("Book is reserved for someone else.");
            return false;
        }
    }

    @Override
    public boolean returnBook(KU00298794_Book book) {
        System.out.println("Book cannot be returned in reserved state.");
        return false;
    }

    @Override
    public boolean reserve(KU00298794_Book book, KU00298794_User user) {
        System.out.println("Book is already reserved. Adding to queue.");
        book.addReservation(user);
        return true;
    }

    @Override
    public String getStateName() {
        return "Reserved";
    }
}
