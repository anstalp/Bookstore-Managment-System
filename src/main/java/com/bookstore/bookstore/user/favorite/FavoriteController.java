package com.bookstore.bookstore.user.favorite;

import com.bookstore.bookstore.book.Book;
import com.bookstore.bookstore.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/favorites")
@RequiredArgsConstructor
public class FavoriteController {

    private final FavoriteService favoriteService;

    @PostMapping
    @PreAuthorize("hasRole('CUSTOMER')")
    public ResponseEntity<?> addToFavorites(
            @AuthenticationPrincipal User user,
            @RequestBody FavoriteRequest request
    ) {
        favoriteService.addToFavorites(user.getId(), request.getBookId());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<?> removeFromFavorites(
            @AuthenticationPrincipal User user,
            @PathVariable Long bookId
    ) {
        favoriteService.removeFromFavorites(user.getId(), bookId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Book>> getFavorites(
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(favoriteService.getUserFavorites(user.getId()));
    }

    @GetMapping("/user/{userId}")
    @PreAuthorize("hasRole('EMPLOYEE')")
    public ResponseEntity<List<Book>> getUserFavorites(@PathVariable Long userId) {
        return ResponseEntity.ok(favoriteService.getUserFavorites(userId));
    }

}
