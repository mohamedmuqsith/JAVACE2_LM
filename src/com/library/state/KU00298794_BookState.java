package com.library.state;

import com.library.model.KU00298794_Book;
import com.library.model.KU00298794_User;

/**
 * STATE PATTERN - Interface for book states
 * Student ID: KU00298794
 */
public interface KU00298794_BookState {
    boolean borrow(KU00298794_Book book, KU00298794_User user);

    boolean returnBook(KU00298794_Book book);

    boolean reserve(KU00298794_Book book, KU00298794_User user);

    String getStateName();
}
