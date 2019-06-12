package com.nuxplanet.library.book.infrastructure;

import com.nuxplanet.library.book.command.NewBookCommand;
import com.nuxplanet.library.book.domain.BookException;
import com.nuxplanet.library.book.dto.BookDetails;
import com.nuxplanet.library.common.book.ISBN;
import com.nuxplanet.library.common.book.BookId;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.nuxplanet.db.generated.tables.Books.BOOKS;

/**
 * @author oleciwoj
 */
@Repository
@AllArgsConstructor
public class BookRepository {

    private final DSLContext dsl;

    public BookId save(NewBookCommand command) {
        final var id = BookId.generate();

        int rows = dsl.insertInto(BOOKS)
                    .set(BOOKS.ID, id.id())
                    .set(BOOKS.ISBN, command.getIsbn().number())
                    .set(BOOKS.TITLE, command.getTitle())
                    .set(BOOKS.DESCRIPTION, command.getDescription())
                    .execute();

        if ( rows !=1 )
            throw new BookException("Could not write Book into DB: " + id);

        return id;
    }

    public Optional<BookDetails> get(BookId id) {
        return dsl.selectFrom(BOOKS)
                .where(BOOKS.ID.eq(id.id()))
                .fetchStream()
                .findAny()
                .map(record -> BookDetails.builder()
                        .id(id)
                        .isbn(ISBN.of(record.getIsbn()))
                        .title(record.getTitle())
                        .description(record.getDescription())
                        .build());
    }
}
