package com.nuxplanet.library.book.dto;

import com.nuxplanet.library.common.book.BookId;
import com.nuxplanet.library.common.book.ISBN;
import lombok.Builder;
import lombok.Value;

/**
 * @author oleciwoj
 */
@Value
@Builder
public class BookDetails {
    private final BookId id;
    private String title;
    private String description;
    private final ISBN isbn;
}
