package com.nuxplanet.library.book.command;

import com.nuxplanet.library.common.book.ISBN;
import lombok.Builder;
import lombok.Value;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author oleciwoj
 */
@Value
@Builder
public class NewBookCommand {

    private final String title;
    private final String description;
    private final ISBN isbn;

    public NewBookCommand(String title, String description, ISBN isbn) {
        checkNotNull(title, "Book title cannot be null");
        checkNotNull(isbn, "Book ISBN cannot be null");
        checkArgument(title.length() < 50, "Book title has invalid size %s", title);
        if (description != null )
            checkArgument(description.length() < 1024, "Book description has invalid size %s", title);

        this.title = title;
        this.description = description;
        this.isbn = isbn;
    }
}
