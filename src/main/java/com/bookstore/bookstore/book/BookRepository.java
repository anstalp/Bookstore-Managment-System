package com.bookstore.bookstore.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(String keyword, String keyword1);

//    @Query("SELECT b FROM Book b WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
//            "OR LOWER(b.author) LIKE LOWER(CONCAT('%', :keyword, '%'))")
//    List<Book> searchByTitleOrAuthor(@Param("keyword") String keyword);

}
