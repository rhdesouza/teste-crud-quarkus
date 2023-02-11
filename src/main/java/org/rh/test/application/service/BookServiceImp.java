package org.rh.test.application.service;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.rh.test.domain.entities.Book;
import org.rh.test.domain.interfaces.BookRepository;
import org.rh.test.domain.interfaces.BookService;
import org.rh.test.infrastructure.persistence.entity.BookEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class BookServiceImp implements BookService {

    @Inject
    BookRepository bookRepository;

    @Transactional
    @Override
    public List<Book> getAllBooks() {
        List<BookEntity> bookEntities = bookRepository.findAll();
        return bookEntities.stream().map(BookEntity::toDomain).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Book findById(Long idBook) {
        Optional<BookEntity> book = bookRepository.findByIdOptional(idBook);
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
            bookEntity = bookRepository.persist(bookEntity);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getCause());
        }
        return bookEntity.toDomain();
    }

    @Override
    @Transactional
    public void delete(Long idBook) {
        try {
            Book book = findById(idBook);
            BookEntity bookEntity = new BookEntity(book);
            bookRepository.delete(bookEntity);
        } catch (Exception ex) {
            ex.getStackTrace();
            throw new RuntimeException(ex.getCause());
        }
    }
}
