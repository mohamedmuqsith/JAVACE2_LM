package com.library.decorator;

import com.library.model.KU00298794_Book;

/**
 * DECORATOR PATTERN - Recommended book decorator
 * Student ID: KU00298794
 */
public class KU00298794_RecommendedBookDecorator extends KU00298794_BookDecorator {
    private String recommendedBy;
    private double rating;

    public KU00298794_RecommendedBookDecorator(KU00298794_Book book, String recommendedBy, double rating) {
        super(book);
        this.recommendedBy = recommendedBy;
        this.rating = rating;
    }

    @Override
    public String getDescription() {
        return "👍 RECOMMENDED: " + decoratedBook.getDescription();
    }

    @Override
    public String getAdditionalInfo() {
        return String.format("Recommended by: %s | Rating: %.1f/5.0", recommendedBy, rating);
    }

    public String getRecommendation() {
        return String.format("Recommended by %s (Rating: %.1f/5.0)", recommendedBy, rating);
    }
}
