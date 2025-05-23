package com.bookstore.bookstore.book;

import jakarta.persistence.Transient;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class BookRequest {
    private String title;
    private String author;
    private String isbn;
    private Integer stock;
    private LocalDate releaseDate;
    private Float price;
}
