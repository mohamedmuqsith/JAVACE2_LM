package com.library.state;

import com.library.model.KU00298794_Book;
import com.library.model.KU00298794_User;

/**
 * STATE PATTERN - Available state (book can be borrowed)
 * Student ID: KU00298794
 */
public class KU00298794_AvailableState implements KU00298794_BookState {

    @Override
    public boolean borrow(KU00298794_Book book, KU00298794_User user) {
        System.out.println("Book '" + book.getTitle() + "' is being borrowed by " + user.getName());
        book.setState(new KU00298794_BorrowedState());
        return true;
    }

    @Override
    public boolean returnBook(KU00298794_Book book) {
        System.out.println("Book is already available. No return needed.");
        return false;
    }

    @Override
    public boolean reserve(KU00298794_Book book, KU00298794_User user) {
        System.out.println("Book is available. Please borrow it instead of reserving.");
        return false;
    }

    @Override
    public String getStateName() {
        return "Available";
    }
}
