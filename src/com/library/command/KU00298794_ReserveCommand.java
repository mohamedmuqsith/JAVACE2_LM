package com.library.command;

import com.library.model.KU00298794_User;
import com.library.model.KU00298794_Book;
import com.library.service.KU00298794_ReservationService;

/**
 * COMMAND PATTERN - Reserve command
 * Student ID: KU00298794
 */
public class KU00298794_ReserveCommand implements KU00298794_Command {
    private KU00298794_User user;
    private KU00298794_Book book;
    private KU00298794_ReservationService service;
    private boolean executed;

    public KU00298794_ReserveCommand(KU00298794_User user, KU00298794_Book book,
            KU00298794_ReservationService service) {
        this.user = user;
        this.book = book;
        this.service = service;
        this.executed = false;
    }

    @Override
    public boolean execute() {
        if (!executed) {
            executed = service.reserveBook(user, book);
            if (executed) {
                System.out.println("[COMMAND EXECUTED] Reserve: " + getDescription());
            }
        }
        return executed;
    }

    @Override
    public boolean undo() {
        if (executed) {
            boolean cancelled = service.cancelReservation(user, book);
            if (cancelled) {
                executed = false;
                System.out.println("[COMMAND UNDONE] Reservation cancelled for: " + getDescription());
                return true;
            }
        }
        return false;
    }

    @Override
    public String getDescription() {
        return String.format("User '%s' reserved book '%s'", user.getName(), book.getTitle());
    }
}
