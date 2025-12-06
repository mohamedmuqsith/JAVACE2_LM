package com.library.model;

import com.library.state.KU00298794_BookState;
import com.library.state.KU00298794_AvailableState;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Book entity with State pattern for availability management
 * Student ID: KU00298794
 */
public class KU00298794_Book {
    private String bookId;
    private String title;
    private String author;
    private String category;
    private String isbn;
    private KU00298794_BookState currentState;
    private List<KU00298794_BorrowRecord> borrowedHistory;
    private Queue<KU00298794_Reservation> reservationQueue;
    private List<KU00298794_Review> reviews;
    private List<String> tags;
    private String edition;

    public KU00298794_Book(String bookId, String title, String author,
            String category, String isbn) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.isbn = isbn;
        this.currentState = new KU00298794_AvailableState();
        this.borrowedHistory = new ArrayList<>();
        this.reservationQueue = new LinkedList<>();
        this.reviews = new ArrayList<>();
        this.tags = new ArrayList<>();
        this.edition = "Standard";
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public String getIsbn() {
        return isbn;
    }

    public KU00298794_BookState getState() {
        return currentState;
    }

    public void setState(KU00298794_BookState state) {
        this.currentState = state;
    }

    public List<KU00298794_BorrowRecord> getBorrowedHistory() {
        return borrowedHistory;
    }

    public void addBorrowRecord(KU00298794_BorrowRecord record) {
        borrowedHistory.add(record);
    }

    public Queue<KU00298794_Reservation> getReservationQueue() {
        return reservationQueue;
    }

    public void addReservation(KU00298794_User user) {
        reservationQueue.offer(new KU00298794_Reservation(
                "RES-" + System.currentTimeMillis(), user, this));
    }

    public KU00298794_User getNextReserver() {
        KU00298794_Reservation res = reservationQueue.poll();
        return res != null ? res.getUser() : null;
    }

    public boolean borrow(KU00298794_User user) {
        return currentState.borrow(this, user);
    }

    public boolean returnBook() {
        return currentState.returnBook(this);
    }

    public boolean reserve(KU00298794_User user) {
        return currentState.reserve(this, user);
    }

    public String getDescription() {
        return String.format("'%s' by %s (ISBN: %s)", title, author, isbn);
    }

    // Builder pattern support - setters for optional metadata
    public void setReviews(List<KU00298794_Review> reviews) {
        this.reviews = reviews;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public List<KU00298794_Review> getReviews() {
        return reviews;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getEdition() {
        return edition;
    }

    @Override
    public String toString() {
        return String.format("Book[ID=%s, Title=%s, Author=%s, State=%s]",
                bookId, title, author, currentState.getStateName());
    }
}
