package com.library.command;

import com.library.model.KU00298794_User;
import com.library.model.KU00298794_Book;
import com.library.service.KU00298794_ReservationService;

/**
 * COMMAND PATTERN - Cancel reservation command
 * Student ID: KU00298794
 */
public class KU00298794_CancelReservationCommand implements KU00298794_Command {
    private KU00298794_User user;
    private KU00298794_Book book;
    private KU00298794_ReservationService service;
    private boolean executed;

    public KU00298794_CancelReservationCommand(KU00298794_User user, KU00298794_Book book,
            KU00298794_ReservationService service) {
        this.user = user;
        this.book = book;
        this.service = service;
        this.executed = false;
    }

    @Override
    public boolean execute() {
        if (!executed) {
            executed = service.cancelReservation(user, book);
            if (executed) {
                System.out.println("[COMMAND EXECUTED] Cancel Reservation: " + getDescription());
            }
        }
        return executed;
    }

    @Override
    public boolean undo() {
        if (executed) {
            boolean reserved = service.reserveBook(user, book);
            if (reserved) {
                executed = false;
                System.out.println("[COMMAND UNDONE] Reservation reinstated for: " + getDescription());
                return true;
            }
        }
        return false;
    }

    @Override
    public String getDescription() {
        return String.format("User '%s' cancelled reservation for book '%s'", user.getName(), book.getTitle());
    }
}
