package com.bookstore.bookstore.book;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private Integer stock;
    private LocalDate releaseDate;
    private Float price;
    @Transient
    private Double averageRating;
}
