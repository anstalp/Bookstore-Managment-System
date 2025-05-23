package com.bookstore.bookstore.user.favorite;

import com.bookstore.bookstore.book.Book;
import com.bookstore.bookstore.book.BookRepository;
import com.bookstore.bookstore.user.User;
import com.bookstore.bookstore.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FavoriteService {
    private final FavoriteRepository favoriteRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public void addToFavorites(Long userId, Long bookId) {
        User user = userRepository.findById(userId).orElseThrow();
        Book book = bookRepository.findById(bookId).orElseThrow();

        if (favoriteRepository.findByUserAndBook(user, book).isEmpty()) {
            Favorite favorite = Favorite.builder().user(user).book(book).build();
            favoriteRepository.save(favorite);
        }
    }

    @Transactional
    public void removeFromFavorites(Long userId, Long bookId) {
        User user = userRepository.findById(userId).orElseThrow();
        Book book = bookRepository.findById(bookId).orElseThrow();
        favoriteRepository.deleteByUserAndBook(user, book);
    }

    public List<Book> getUserFavorites(Long userId) {
        return favoriteRepository.findByUserId(userId).stream()
                .map(Favorite::getBook)
                .collect(Collectors.toList());
    }



}

