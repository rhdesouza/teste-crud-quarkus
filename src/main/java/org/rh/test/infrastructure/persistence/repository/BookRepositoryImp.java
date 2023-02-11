package org.rh.test.infrastructure.persistence.repository;

import org.rh.test.domain.entities.Book;
import org.rh.test.domain.interfaces.BookRepository;
import org.rh.test.infrastructure.persistence.entity.BookEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepositoryImp implements BookRepository {
    @Transactional
    @Override
    public List<BookEntity> findAll() {
        return BookEntity.listAll();
    }

    @Override
    public Optional<BookEntity> findByIdOptional(Long idBook) {
        return BookEntity.findByIdOptional(idBook);
    }

    @Override
    public BookEntity persist(BookEntity bookEntity) {
        bookEntity.persist();
        return bookEntity;
    }

    @Override
    public void delete(BookEntity bookEntity) {
        bookEntity.delete();
    }
}
