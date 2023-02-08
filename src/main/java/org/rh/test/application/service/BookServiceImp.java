package org.rh.test.application.service;

import org.rh.test.domain.entities.Book;
import org.rh.test.domain.interfaces.BookService;
import org.rh.test.infrastructure.persistence.entity.BookEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class BookServiceImp implements BookService {

    @Override
    @Transactional
    public List<Book> getAllBooks() {
        List<BookEntity> bookEntities = BookEntity.listAll();
        return bookEntities.stream().map(BookEntity::toDomain).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Book findById(Long idBook) {
        Optional<BookEntity> book = BookEntity.findByIdOptional(idBook);
        if (book.isEmpty()) {
            throw new NotFoundException("Book not found.");
        }
        return book.get().toDomain();
    }

    @Transactional
    @Override
    public Book create(Book book) {
        BookEntity bookEntity = new BookEntity(book);
        try {
            bookEntity.persist();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getCause());
        }
        return bookEntity.toDomain();
    }

    @Override
    @Transactional
    public void delete(Long idBook) {
        Book book = findById(idBook);
        try {
            BookEntity bookEntity = new BookEntity(book);
            bookEntity.delete();
        } catch (Exception ex) {
            throw new RuntimeException(ex.getCause());
        }
    }
}
