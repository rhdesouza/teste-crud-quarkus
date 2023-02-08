package org.rh.test.application.service;

import org.rh.test.domain.entities.Book;
import org.rh.test.domain.interfaces.BookService;
import org.rh.test.infrastructure.persistence.entity.BookEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;


@ApplicationScoped
public class BookServiceImp implements BookService {

    @Override
    public List<Book> getAllBooks() {
        List<BookEntity> bookEntities = BookEntity.listAll();
        return bookEntities.stream().map(BookEntity::toDomain).collect(Collectors.toList());
    }
}
