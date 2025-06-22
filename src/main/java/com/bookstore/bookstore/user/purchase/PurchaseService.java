package com.bookstore.bookstore.user.purchase;

import com.bookstore.bookstore.book.Book;
import com.bookstore.bookstore.book.BookRepository;
import com.bookstore.bookstore.user.User;
import com.bookstore.bookstore.user.UserRepository;
import com.bookstore.bookstore.user.UserRole;
import jakarta.persistence.EntityNotFoundException;
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
    public void createPurchase(Long customerId, Long bookId, Integer quantity, User authenticatedUser) {

        if (authenticatedUser.getRole() != UserRole.CUSTOMER) {

            if (customerId == null) {
                throw new IllegalArgumentException("πρέπει να επιλέξεις πελάτη");
            }
        } else {
            // Ο πελάτης αγοράζει μόνο για τον εαυτό του
            customerId = authenticatedUser.getId();
        }

        User customer = userRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Δεν βρέθηκε πελάτης"));

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("Δεν βρέθηκε βιβλίο"));


        if (book.getStock() < quantity) {
            throw new RuntimeException("Δεν υπάρχει αρκετό stock");
        }
        book.setStock(book.getStock() - quantity);
        bookRepository.save(book);

        // Δημιουργία αγοράς
        Purchase purchase = Purchase.builder()
                .user(customer)
                .book(book)
                .quantity(quantity)
                .totalPrice((double) (book.getPrice() * quantity))
                .build();

        purchaseRepository.save(purchase);
    }

    @Transactional
    public void deletePurchaseByUserAndBook(Long userId, Long bookId) {
        purchaseRepository.deleteByUserIdAndBookId(userId, bookId);
    }

    public List<PurchaseResponse> getUserPurchases(Long userId) {
        return purchaseRepository.findByUserId(userId).stream()
                .map(purchase -> new PurchaseResponse(
                        purchase.getBook().getId(),
                        purchase.getBook().getTitle(),
                        purchase.getBook().getAuthor(),
                        purchase.getQuantity(),
                        purchase.getTotalPrice(),
                        purchase.getPurchaseDate()
                ))
                .collect(Collectors.toList());
    }

}