package org.rh.test.infrastructure.persistence.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.rh.test.domain.entities.Book;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "book")
public class BookEntity extends PanacheEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "launch_year")
    private Integer launchYear;

    @Column(name = "pages")
    private Integer pages;

    @Column(name = "creation_date")
    @CreationTimestamp
    private Date creationDate;

    @Column(name = "update_date")
    @UpdateTimestamp
    private Date updateDate;

    public Book toDomain() {
        return Book.builder()
                .id(this.id)
                .title(this.title)
                .launchYear(this.launchYear)
                .pages(this.pages)
                .creationDate(this.creationDate)
                .updateDate(this.updateDate)
                .build();
    }

}
