package com.nuxplanet.library.book;

import com.nuxplanet.library.book.command.NewBookCommand;
import com.nuxplanet.library.book.dto.BookDetails;
import com.nuxplanet.library.common.book.BookId;

import java.util.Optional;

/**
 * Main facade of Book bounded context
 *
 * @author oleciwoj
 */
public interface BookStore {

    BookId add(NewBookCommand command);

    Optional<BookDetails> get(BookId id);

    boolean delete(BookId id);
}
