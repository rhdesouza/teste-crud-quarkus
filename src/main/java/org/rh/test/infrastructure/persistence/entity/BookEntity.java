package org.rh.test.infrastructure.persistence.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.NoArgsConstructor;
import org.rh.test.domain.entities.Book;

import javax.persistence.*;

@Entity(name = "book")
@NoArgsConstructor
public class BookEntity extends PanacheEntityBase {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "launch_year")
    private Integer launchYear;

    @Column(name = "pages")
    private Integer pages;
    @Column(name = "author")
    private String author;

    public Book toDomain() {
        return Book.builder()
                .id(this.id)
                .title(this.title)
                .launchYear(this.launchYear)
                .pages(this.pages)
                .author(this.author)
                .build();
    }

    public BookEntity(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.launchYear = book.getLaunchYear();
        this.pages = book.getPages();
        this.author = book.getAuthor();
    }
}
