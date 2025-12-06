package com.library.model;

import java.util.Date;

/**
 * Represents a review and rating for a book.
 * Student ID: KU00298794
 */
public class KU00298794_Review {
    private String reviewerName;
    private double rating;
    private String comment;
    private Date date;

    public KU00298794_Review(String reviewerName, double rating, String comment) {
        this.reviewerName = reviewerName;
        this.rating = rating;
        this.comment = comment;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return String.format("★ %.1f by %s: %s", rating, reviewerName, comment);
    }

    public String getReviewerName() { return reviewerName; }
    public double getRating() { return rating; }
    public String getComment() { return comment; }
}
