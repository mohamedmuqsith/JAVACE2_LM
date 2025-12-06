package com.library.builder;

import com.library.model.KU00298794_Book;
import com.library.model.KU00298794_Review;
import java.util.ArrayList;
import java.util.List;

/**
 * BUILDER PATTERN - Build complex Book objects with optional metadata
 * Student ID: KU00298794
 */
public class KU00298794_BookBuilder {
    private String bookId;
    private String title;
    private String author;
    private String category;
    private String isbn;
    private List<KU00298794_Review> reviews;
    private List<String> tags;
    private String edition;

    public KU00298794_BookBuilder() {
        this.reviews = new ArrayList<>();
        this.tags = new ArrayList<>();
        this.edition = "Standard";
    }

    public KU00298794_BookBuilder setBookId(String bookId) {
        this.bookId = bookId;
        return this;
    }

    public KU00298794_BookBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public KU00298794_BookBuilder setAuthor(String author) {
        this.author = author;
        return this;
    }

    public KU00298794_BookBuilder setCategory(String category) {
        this.category = category;
        return this;
    }

    public KU00298794_BookBuilder setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public KU00298794_BookBuilder addReview(String reviewer, double rating, String comment) {
        this.reviews.add(new KU00298794_Review(reviewer, rating, comment));
        return this;
    }

    public KU00298794_BookBuilder addTag(String tag) {
        this.tags.add(tag);
        return this;
    }

    public KU00298794_BookBuilder setEdition(String edition) {
        this.edition = edition;
        return this;
    }

    public KU00298794_Book build() {
        if (bookId == null || title == null || author == null || category == null || isbn == null) {
            throw new IllegalStateException("Required fields missing for Book");
        }

        KU00298794_Book book = new KU00298794_Book(bookId, title, author, category, isbn);
        book.setReviews(reviews);
        book.setTags(tags);
        book.setEdition(edition);

        return book;
    }
}
