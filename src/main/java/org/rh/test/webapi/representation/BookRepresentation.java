package org.rh.test.webapi.representation;

import io.smallrye.common.constraint.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.rh.test.domain.entities.Book;

import java.util.Date;

@Getter
@Setter
public class BookRepresentation {

    private Long id;

    private String titulo;

    private Integer anoLancamento;

    private Integer paginas;

    private String autor;

    public BookRepresentation(@NotNull Book bookDomain){
        this.id = bookDomain.getId();
        this.titulo = bookDomain.getTitle();
        this.anoLancamento = bookDomain.getLaunchYear();
        this.paginas = bookDomain.getPages();
        this.autor = bookDomain.getAuthor();
    }

    public Book toDomain(){
        return Book.builder()
                .id(this.id)
                .title(this.titulo)
                .launchYear(this.anoLancamento)
                .pages(this.paginas)
                .author(this.autor)
                .build();
    }
}
