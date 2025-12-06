package com.library.command;

import com.library.model.KU00298794_User;
import com.library.model.KU00298794_Book;
import com.library.service.KU00298794_BorrowingService;

/**
 * COMMAND PATTERN - Return command
 * Student ID: KU00298794
 */
public class KU00298794_ReturnCommand implements KU00298794_Command {
    private KU00298794_User user;
    private KU00298794_Book book;
    private KU00298794_BorrowingService service;
    private boolean executed;

    public KU00298794_ReturnCommand(KU00298794_User user, KU00298794_Book book,
            KU00298794_BorrowingService service) {
        this.user = user;
        this.book = book;
        this.service = service;
        this.executed = false;
    }

    @Override
    public boolean execute() {
        if (!executed) {
            executed = service.returnBook(user, book);
            if (executed) {
                System.out.println("[COMMAND EXECUTED] Return: " + getDescription());
            }
        }
        return executed;
    }

    @Override
    public boolean undo() {
        if (executed) {
            boolean borrowed = service.borrowBook(user, book);
            if (borrowed) {
                executed = false;
                System.out.println("[COMMAND UNDONE] Return undone for: " + getDescription());
                return true;
            }
        }
        return false;
    }

    @Override
    public String getDescription() {
        return String.format("User '%s' returned book '%s'", user.getName(), book.getTitle());
    }
}
