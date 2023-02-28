package org.rh.test.webapi.representation;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookRepresentation {

    private Long id;

    private String titulo;

    private Integer anoLancamento;

    private Integer paginas;

    private String autor;

}
