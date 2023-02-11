package org.rh.test.application.unit.service;

import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import io.vertx.core.cli.annotations.Description;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.rh.test.application.service.BookServiceImp;
import org.rh.test.domain.entities.Book;
import org.rh.test.infrastructure.persistence.entity.BookEntity;
import org.rh.test.infrastructure.persistence.repository.BookRepositoryImp;

import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;


@QuarkusTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BookServiceImpTest {

    @Inject
    private BookServiceImp bookServiceImp;

    @Inject
    private BookRepositoryImp bookRepositoryImp;

    @BeforeAll
    void setup() {
        bookRepositoryImp = Mockito.mock(BookRepositoryImp.class);
        QuarkusMock.installMockForType(bookRepositoryImp, BookRepositoryImp.class);
    }

    @Test
    @Description("Retorna a lista de todos livros")
    void getAllBooks_returnList() {
        List<BookEntity> expectedUsers = List.of(new BookEntity(), new BookEntity());
        Mockito.when(bookRepositoryImp.findAll()).thenReturn(expectedUsers);

        List<Book> bookList = bookServiceImp.getAllBooks();

        Assertions.assertEquals(expectedUsers.size(), bookList.size());
    }

    @Test
    @Description("Retorna o livro procurado")
    void findById_success() {
        Book bookMock = new EasyRandom().nextObject(Book.class);
        BookEntity bookEntity = new BookEntity(bookMock);
        Mockito.when(bookRepositoryImp.findByIdOptional(any(Long.class))).thenReturn(Optional.of(bookEntity));

        Book book = bookServiceImp.findById(1L);

        Assertions.assertEquals(bookMock.toString(), book.toString());
    }

    @Test
    @Description("Retorna 404 quando o livro não existe")
    void findById_notFoundException() {
        Mockito.when(bookRepositoryImp.findByIdOptional(any(Long.class))).thenReturn(Optional.empty());

        NotFoundException notFoundException = Assertions.assertThrows(NotFoundException.class,
                () -> bookServiceImp.findById(1L));

        Assertions.assertEquals("Book not found.", notFoundException.getMessage());
    }

    @Test
    @Description("Retorna o usuário criado")
    void create_success() {
        Book bookMock = new EasyRandom().nextObject(Book.class);
        BookEntity bookEntityMock = new BookEntity(bookMock);
        Mockito.when(bookRepositoryImp.persist(bookEntityMock)).thenReturn(bookEntityMock);

        Book bookSaved = bookServiceImp.create(bookMock);

        Assertions.assertEquals(bookMock.toString(), bookSaved.toString());
    }

    @Test
    @Description("Retorna a exceção RuntimeException quando ocorre um erro ao salvar")
    void create_runtimeException() {
        Book bookMock = new EasyRandom().nextObject(Book.class);
        BookEntity bookEntityMock = new BookEntity(bookMock);
        Mockito.when(bookRepositoryImp.persist(bookEntityMock)).thenThrow(NullPointerException.class);

        Assertions.assertThrows(RuntimeException.class, () -> bookServiceImp.create(bookMock));
    }

    @Test
    @Description("Deleta um usuário com sucesso")
    void delete_success() {
        Book bookMock = new EasyRandom().nextObject(Book.class);
        BookEntity bookEntity = new BookEntity(bookMock);
        Mockito.when(bookRepositoryImp.findByIdOptional(any(Long.class))).thenReturn(Optional.of(bookEntity));

        bookServiceImp.delete(1l);
    }

    @Test
    @Description("Emite uma exceção ao deletar um usuário")
    void delete_exception() {
        Mockito.when(bookRepositoryImp.findByIdOptional(any(Long.class))).thenReturn(Optional.empty());

        Assertions.assertThrows(RuntimeException.class, () -> bookServiceImp.delete(1l));
    }

}