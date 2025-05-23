package com.bookstore.bookstore.book;

import com.bookstore.bookstore.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody BookRequest request) {
        service.save(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<Book>> findAllBooks() {
        return ResponseEntity.ok(service.findAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> search(@RequestParam("keyword") String keyword) {
        return ResponseEntity.ok(service.search(keyword));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStock(
            @PathVariable Long id,
            @RequestParam("stock") Integer newStock
    ) {
        service.updateStock(id, newStock);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/average-rating")
    public ResponseEntity<Double> getAverageRating(@PathVariable Long id) {
        return ResponseEntity.ok(service.calculateAverageRating(id));
    }

    @PostMapping("/{id}/rate")
    public ResponseEntity<?> rateBook(
            @PathVariable Long id,
            @AuthenticationPrincipal User user, // Απαιτεί ρύθμιση Spring Security
            @RequestParam Integer rating
    ) {
        service.savePersonalRating(id, user, rating);
        return ResponseEntity.ok().build();
    }



}
