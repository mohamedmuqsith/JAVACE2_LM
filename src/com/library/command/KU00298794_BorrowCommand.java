package com.library.command;

import com.library.model.KU00298794_User;
import com.library.model.KU00298794_Book;
import com.library.service.KU00298794_BorrowingService;

/**
 * COMMAND PATTERN - Borrow command
 * Student ID: KU00298794
 */
public class KU00298794_BorrowCommand implements KU00298794_Command {
    private KU00298794_User user;
    private KU00298794_Book book;
    private KU00298794_BorrowingService service;
    private boolean executed;

    public KU00298794_BorrowCommand(KU00298794_User user, KU00298794_Book book,
            KU00298794_BorrowingService service) {
        this.user = user;
        this.book = book;
        this.service = service;
        this.executed = false;
    }

    @Override
    public boolean execute() {
        if (!executed) {
            executed = service.borrowBook(user, book);
            if (executed) {
                System.out.println("[COMMAND EXECUTED] Borrow: " + getDescription());
            }
        }
        return executed;
    }

    @Override
    public boolean undo() {
        if (executed) {
            boolean returned = service.returnBook(user, book);
            if (returned) {
                executed = false;
                System.out.println("[COMMAND UNDONE] Borrow undone for: " + getDescription());
                return true;
            }
        }
        return false;
    }

    @Override
    public String getDescription() {
        return String.format("User '%s' borrowed book '%s'", user.getName(), book.getTitle());
    }
}
