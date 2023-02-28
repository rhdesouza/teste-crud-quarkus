package org.rh.test.webapi.controller;

import org.rh.test.application.service.BookServiceImp;
import org.rh.test.domain.entities.Book;
import org.rh.test.infrastructure.mapper.BookMapper;
import org.rh.test.webapi.representation.BookRepresentation;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/v1/book")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookController {

    @Inject
    private BookServiceImp bookService;

    @Inject
    BookMapper bookMapper;

    @GET
    public List<BookRepresentation> getAllBooks() {
        List<BookRepresentation> bookRepresentations = bookService.getAllBooks()
                .stream()
                .map(bookMapper::toRepresentation)
                .collect(Collectors.toList());

        return bookRepresentations;
    }

    @GET()
    @Path("{id}")
    public BookRepresentation findBookById(@PathParam("id") Long idBook) {
        Book book = bookService.findById(idBook);
        return bookMapper.toRepresentation(book);
    }

    @POST()
    public BookRepresentation create(BookRepresentation bookRepresentation) {
        Book book = bookService.create(bookMapper.toDomain(bookRepresentation));
        return bookMapper.toRepresentation(book);
    }

    @DELETE()
    @Path("{id}")
    public void deleteBook(@PathParam("id") Long idBook) {
        bookService.delete(idBook);
    }
}
