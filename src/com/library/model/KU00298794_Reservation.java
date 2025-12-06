package com.library.model;

import java.util.Date;

/**
 * Represents a reservation made by a user for a book.
 * Student ID: KU00298794
 */
public class KU00298794_Reservation {
    private String reservationId;
    private KU00298794_User user;
    private KU00298794_Book book;
    private Date reservationDate;
    private String status; // "Active", "Fulfilled", "Cancelled"

    public KU00298794_Reservation(String reservationId, KU00298794_User user, KU00298794_Book book) {
        this.reservationId = reservationId;
        this.user = user;
        this.book = book;
        this.reservationDate = new Date();
        this.status = "Active";
    }

    public void fulfill() {
        this.status = "Fulfilled";
    }

    public void cancel() {
        this.status = "Cancelled";
    }

    public String getReservationId() { return reservationId; }
    public KU00298794_User getUser() { return user; }
    public KU00298794_Book getBook() { return book; }
    public Date getReservationDate() { return reservationDate; }
    public String getStatus() { return status; }
}
