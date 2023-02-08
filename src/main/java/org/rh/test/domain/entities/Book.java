package org.rh.test.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Book {

    private Long id;

    private String title;

    private Integer launchYear;

    private Integer pages;

    private String author;

}
