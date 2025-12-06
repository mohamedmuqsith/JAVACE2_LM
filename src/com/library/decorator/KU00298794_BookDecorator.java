package com.library.decorator;

import com.library.model.KU00298794_Book;

/**
 * DECORATOR PATTERN - Abstract decorator for Book features
 * Student ID: KU00298794
 */
public abstract class KU00298794_BookDecorator {
    protected KU00298794_Book decoratedBook;

    public KU00298794_BookDecorator(KU00298794_Book book) {
        this.decoratedBook = book;
    }

    public KU00298794_Book getDecoratedBook() {
        return decoratedBook;
    }

    public abstract String getDescription();

    public abstract String getAdditionalInfo();
}
