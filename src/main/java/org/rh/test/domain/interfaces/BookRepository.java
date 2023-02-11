package org.rh.test.domain.interfaces;

import org.rh.test.domain.entities.Book;
import org.rh.test.infrastructure.persistence.entity.BookEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;


public interface BookRepository {

    List<BookEntity> findAll();

    Optional<BookEntity> findByIdOptional(Long idBook);

    BookEntity persist(BookEntity bookEntity);

    void delete(BookEntity bookEntity);

}
