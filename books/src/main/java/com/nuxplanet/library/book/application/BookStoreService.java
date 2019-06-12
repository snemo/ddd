package com.nuxplanet.library.book.application;

import com.nuxplanet.library.book.BookStore;
import com.nuxplanet.library.book.command.NewBookCommand;
import com.nuxplanet.library.book.dto.BookDetails;
import com.nuxplanet.library.book.infrastructure.BookRepository;
import com.nuxplanet.library.common.book.BookId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author oleciwoj
 */
@Service
@AllArgsConstructor
class BookStoreService implements BookStore {

    private final BookRepository repository;

    @Override
    public BookId add(NewBookCommand command) {
        return repository.save(command);
    }

    @Override
    public Optional<BookDetails> get(BookId id) {
        return repository.get(id);
    }

    @Override
    public boolean delete(BookId id) {
        return false;
    }
}
