package com.bookstore.bookstore.book;

import com.bookstore.bookstore.user.User;
import com.bookstore.bookstore.user.rating.UserRating;
import com.bookstore.bookstore.user.rating.UserRatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;
    private final UserRatingRepository userRatingRepository;


    public void save(BookRequest request) {
        var book = Book.builder()
                .title(request.getTitle())
                .author(request.getAuthor())
                .isbn(request.getIsbn())
                .stock(request.getStock())
                .releaseDate(request.getReleaseDate())
                .price(request.getPrice())
                .build();
        repository.save(book);
    }

    public void savePersonalRating(Long bookId, User user, Integer rating) {
        Book book = repository.findById(bookId).orElseThrow();

        UserRating userRating = userRatingRepository.findByUserAndBook(user, book)
                .orElse(UserRating.builder().user(user).book(book).build());

        userRating.setPersonalRating(rating);
        userRatingRepository.save(userRating);
    }

    public Double calculateAverageRating(Long bookId) {
        List<UserRating> ratings = userRatingRepository.findByBookId(bookId);
        return ratings.stream()
                .mapToInt(UserRating::getPersonalRating)
                .average()
                .orElse(0.0);
    }


    public List<Book> findAllBooks() {
        List<Book> books = repository.findAll();
        books.forEach(book ->
                book.setAverageRating(calculateAverageRating(book.getId())));
        return books;
    }

    public Optional<Book> findById(Long id) {
        Optional<Book> bookOpt = repository.findById(id);
        bookOpt.ifPresent(book ->
                book.setAverageRating(calculateAverageRating(id)));
        return bookOpt;
    }

    public List<Book> search(String keyword) {
        return repository.findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(keyword, keyword);
    }


    public void updateStock(Long id, Integer newStock) {
        var book = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        book.setStock(newStock);
        repository.save(book);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }


}
