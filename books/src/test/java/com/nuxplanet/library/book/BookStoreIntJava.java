package com.nuxplanet.library.book;

import com.nuxplanet.library.book.command.NewBookCommand;
import com.nuxplanet.library.common.book.BookId;
import com.nuxplanet.library.common.book.ISBN;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author oleciwoj
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ConfigJava.class)
public class BookStoreIntJava {

    @Autowired
    private BookStore bookStore;

    @Test
    public void add_new_book() {
        // given
        var command = NewBookCommand.builder()
                .isbn(ISBN.of("3403033040"))
                .title("Inferno")
                .description("Bes book")
                .build();

        // when
        BookId id = bookStore.add(command);

        // then

    }

    @Test
    public void get_book() {

    }

    @Test
    public void delete_book() {

    }

}