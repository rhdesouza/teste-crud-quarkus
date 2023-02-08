package org.rh.test.webapi.controller;

import org.rh.test.application.service.BookServiceImp;
import org.rh.test.domain.interfaces.BookService;
import org.rh.test.webapi.representation.BookRepresentation;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/v1/book")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookController {

    @Inject
    private BookServiceImp bookService;

    @GET
    public List<BookRepresentation> getAllBooks(){
        List<BookRepresentation> bookRepresentations = bookService.getAllBooks()
                .stream()
                .map(BookRepresentation::new)
                .collect(Collectors.toList());

        return bookRepresentations;
    }


}
