package com.bookstore.bookstore.user.rating;


import com.bookstore.bookstore.book.Book;
import com.bookstore.bookstore.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRatingRepository extends JpaRepository<UserRating, Long> {
    Optional<UserRating> findByUserAndBook(User user, Book book);
    List<UserRating> findByBookId(Long bookId);
}
