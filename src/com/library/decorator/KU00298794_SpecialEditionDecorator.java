package com.library.decorator;

import com.library.model.KU00298794_Book;

/**
 * DECORATOR PATTERN - Special edition book decorator
 * Student ID: KU00298794
 */
public class KU00298794_SpecialEditionDecorator extends KU00298794_BookDecorator {
    private String editionType;
    private String specialFeatures;

    public KU00298794_SpecialEditionDecorator(KU00298794_Book book, String editionType, String specialFeatures) {
        super(book);
        this.editionType = editionType;
        this.specialFeatures = specialFeatures;
    }

    @Override
    public String getDescription() {
        return "💎 SPECIAL EDITION: " + decoratedBook.getDescription();
    }

    @Override
    public String getAdditionalInfo() {
        return String.format("Edition: %s | Features: %s", editionType, specialFeatures);
    }

    public String getEditionInfo() {
        return String.format("%s Edition - %s", editionType, specialFeatures);
    }
}
