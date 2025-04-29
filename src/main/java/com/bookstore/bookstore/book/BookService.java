package com.bookstore.bookstore.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;

    public void save(BookRequest request) {
        var book = Book.builder()
                .title(request.getTitle())
                .author(request.getAuthor())
                .isbn(request.getIsbn())
                .stock(request.getStock())
                .releaseDate(request.getReleaseDate())
                .build();
        repository.save(book);
    }

    public List<Book> findAllBooks() {
        return repository.findAll();
    }

    public Optional<Book> findById(Integer id) {
        return repository.findById(id);
    }

    public List<Book> search(String keyword) {
        return repository.findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(keyword, keyword);
    }


    public void updateStock(Integer id, Integer newStock) {
        var book = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        book.setStock(newStock);
        repository.save(book);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }


}
