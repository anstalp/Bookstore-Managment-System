package com.bookstore.bookstore.book;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.bookstore.user.favorite.Favorite;
import com.bookstore.bookstore.user.purchase.Purchase;
import com.bookstore.bookstore.user.rating.UserRating;


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
