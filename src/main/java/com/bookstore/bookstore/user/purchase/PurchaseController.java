package com.bookstore.bookstore.user.purchase;

import com.bookstore.bookstore.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/purchases")
@RequiredArgsConstructor
public class PurchaseController {
    private final PurchaseService purchaseService;

    @PostMapping
    @PreAuthorize("hasAnyRole('CUSTOMER', 'EMPLOYEE')")
    public ResponseEntity<?> createPurchase(
            @RequestBody PurchaseRequest request,
            @AuthenticationPrincipal User authenticatedUser
    ) {
        purchaseService.createPurchase(
                request.getCustomerId(),
                request.getBookId(),
                request.getQuantity(),
                authenticatedUser
        );
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/user/{userId}/book/{bookId}")
    @PreAuthorize("hasAnyRole('EMPLOYEE','OWNER')")
    public ResponseEntity<?> deletePurchaseByUserAndBook(
            @PathVariable Long userId,
            @PathVariable Long bookId) {
        purchaseService.deletePurchaseByUserAndBook(userId, bookId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<PurchaseResponse>> getPurchaseHistory(@AuthenticationPrincipal User user) {
        List<PurchaseResponse> purchases = purchaseService.getUserPurchases(user.getId());
        return ResponseEntity.ok(purchases);
    }

    @GetMapping("/user/{userId}")
    @PreAuthorize("hasAnyRole('EMPLOYEE','OWNER')")
    public ResponseEntity<List<PurchaseResponse>> getUserPurchases(@PathVariable Long userId) {
        return ResponseEntity.ok(purchaseService.getUserPurchases(userId));
    }


}

