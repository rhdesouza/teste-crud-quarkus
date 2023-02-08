package org.rh.test.domain.interfaces;

import org.rh.test.domain.entities.Book;
import org.rh.test.webapi.representation.BookRepresentation;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book findById(Long idBook);

    Book create(Book book);

    void delete(Long idBook);
}
