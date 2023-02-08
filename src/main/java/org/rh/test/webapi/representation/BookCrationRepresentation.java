package org.rh.test.webapi.representation;

import lombok.Getter;
import lombok.Setter;
import org.rh.test.domain.entities.Book;

@Getter
@Setter
public class BookCrationRepresentation {

    private Long id;

    private String titulo;

    private Integer anoLancamento;

    private Integer paginas;

    private String autor;

    public Book toDomain() {
        return Book.builder()
                .id(this.id)
                .title(this.titulo)
                .launchYear(this.anoLancamento)
                .pages(this.paginas)
                .author(this.autor)
                .build();
    }
}
