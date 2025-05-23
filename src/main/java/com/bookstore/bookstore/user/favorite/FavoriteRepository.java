package com.bookstore.bookstore.user.favorite;

import com.bookstore.bookstore.book.Book;
import com.bookstore.bookstore.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findByUserId(Long userId);
    Optional<Favorite> findByUserAndBook(User user, Book book);

    void deleteByUserAndBook(User user, Book book);
}

