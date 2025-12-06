package com.library.state;

import com.library.model.KU00298794_Book;
import com.library.model.KU00298794_User;

/**
 * STATE PATTERN - Borrowed state (book is currently borrowed)
 * Student ID: KU00298794
 */
public class KU00298794_BorrowedState implements KU00298794_BookState {

    @Override
    public boolean borrow(KU00298794_Book book, KU00298794_User user) {
        System.out.println("Book is currently borrowed. Please reserve it.");
        return false;
    }

    @Override
    public boolean returnBook(KU00298794_Book book) {
        System.out.println("Book '" + book.getTitle() + "' is being returned.");
        // Check if there are reservations
        if (!book.getReservationQueue().isEmpty()) {
            book.setState(new KU00298794_ReservedState());
            System.out.println("Book moves to Reserved state for next reserver.");
        } else {
            book.setState(new KU00298794_AvailableState());
            System.out.println("Book is now available.");
        }
        return true;
    }

    @Override
    public boolean reserve(KU00298794_Book book, KU00298794_User user) {
        System.out.println("Book reserved by " + user.getName());
        book.addReservation(user);
        return true;
    }

    @Override
    public String getStateName() {
        return "Borrowed";
    }
}
