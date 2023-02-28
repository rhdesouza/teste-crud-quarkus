package org.rh.test.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.rh.test.domain.entities.Book;
import org.rh.test.webapi.representation.BookRepresentation;

@Mapper(componentModel = "cdi")
public interface BookMapper {

    @Mappings({
            @Mapping(target = "titulo", source = "title"),
            @Mapping(target = "anoLancamento", source = "launchYear"),
            @Mapping(target = "paginas", source = "pages"),
            @Mapping(target = "autor", source = "author"),
    })
    BookRepresentation toRepresentation(Book bookDomain);

    @Mappings({
            @Mapping(target = "title", source = "titulo"),
            @Mapping(target = "launchYear", source = "anoLancamento"),
            @Mapping(target = "pages", source = "paginas"),
            @Mapping(target = "author", source = "autor"),
    })
    Book toDomain(BookRepresentation bookRepresentation);

}
