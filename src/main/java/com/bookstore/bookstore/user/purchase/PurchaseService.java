package com.bookstore.bookstore.user.purchase;

import com.bookstore.bookstore.book.Book;
import com.bookstore.bookstore.book.BookRepository;
import com.bookstore.bookstore.user.User;
import com.bookstore.bookstore.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Transactional
    public void createPurchase(Long userId, Long bookId, Integer quantity) {
        User user = userRepository.findById(userId).orElseThrow();
        Book book = bookRepository.findById(bookId).orElseThrow();

        // Ενημέρωση stock
        if (book.getStock() < quantity) {
            throw new RuntimeException("Δεν υπάρχει αρκετό stock");
        }
        book.setStock(book.getStock() - quantity);
        bookRepository.save(book);

        // Δημιουργία αγοράς
        Purchase purchase = Purchase.builder()
                .user(user)
                .book(book)
                .quantity(quantity)
                .totalPrice((double) (book.getPrice() * quantity))
                .build();

        purchaseRepository.save(purchase);
    }


    public List<PurchaseResponse> getUserPurchases(Long userId) {
        return purchaseRepository.findByUserId(userId).stream()
                .map(purchase -> new PurchaseResponse(
                        purchase.getId(),
                        purchase.getBook().getTitle(),
                        purchase.getBook().getAuthor(),
                        purchase.getQuantity(),
                        purchase.getTotalPrice(),
                        purchase.getPurchaseDate()
                ))
                .collect(Collectors.toList());
    }


}