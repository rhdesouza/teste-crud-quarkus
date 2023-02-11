package org.rh.test.domain.entities;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Book {

    private Long id;

    private String title;

    private Integer launchYear;

    private Integer pages;

    private String author;

}
