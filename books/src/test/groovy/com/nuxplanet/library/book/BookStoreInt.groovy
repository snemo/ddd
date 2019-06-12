package com.nuxplanet.library.book


import com.nuxplanet.library.book.command.NewBookCommand
import com.nuxplanet.library.book.dto.BookDetails
import com.nuxplanet.library.common.book.BookId
import com.nuxplanet.library.common.book.ISBN
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

//@SpringBootTest(classes = ConfigJava.class)
class BookStoreInt extends Specification {

    @Autowired
    BookStore bookStore

    def 'should be able to save and load new book'() {
        given:
        NewBookCommand command = NewBookCommand.builder()
                .isbn(ISBN.of("3403033040"))
                .title("Inferno")
                .description("Bes book")
                .build()
        when:
        BookId id = bookStore.add(command)
        and:
        Optional<BookDetails> book = bookStore.get(id)
        then:
        book.isEmpty()
    }

}