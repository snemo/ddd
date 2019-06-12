package com.nuxplanet.library.book.domain;

import com.nuxplanet.library.common.book.BookId;
import com.nuxplanet.library.common.book.ISBN;
import lombok.AllArgsConstructor;

/**
 * Aggregate
 *
 * @author oleciwoj
 */
@AllArgsConstructor
class Book {

    private final BookId id;
    private String title;
    private String description;
    private final ISBN isbn;
}
