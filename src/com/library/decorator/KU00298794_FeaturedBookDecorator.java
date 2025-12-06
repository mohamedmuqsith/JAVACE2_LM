package com.library.decorator;

import com.library.model.KU00298794_Book;

/**
 * DECORATOR PATTERN - Featured book decorator
 * Student ID: KU00298794
 */
public class KU00298794_FeaturedBookDecorator extends KU00298794_BookDecorator {
    private String featuredReason;

    public KU00298794_FeaturedBookDecorator(KU00298794_Book book, String featuredReason) {
        super(book);
        this.featuredReason = featuredReason;
    }

    @Override
    public String getDescription() {
        return "⭐ FEATURED: " + decoratedBook.getDescription();
    }

    @Override
    public String getAdditionalInfo() {
        return "Featured because: " + featuredReason;
    }

    public String getFeaturedReason() {
        return featuredReason;
    }
}
