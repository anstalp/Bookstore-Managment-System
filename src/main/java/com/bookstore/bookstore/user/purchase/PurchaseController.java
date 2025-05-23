package com.bookstore.bookstore.user.purchase;

import com.bookstore.bookstore.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/purchases")
@RequiredArgsConstructor
public class PurchaseController {
    private final PurchaseService purchaseService;

    @PostMapping
    public ResponseEntity<?> createPurchase(
            @AuthenticationPrincipal User user,
            @RequestBody PurchaseRequest request
    ) {
        purchaseService.createPurchase(user.getId(), request.getBookId(), request.getQuantity());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<PurchaseResponse>> getPurchaseHistory(@AuthenticationPrincipal User user) {
        List<PurchaseResponse> purchases = purchaseService.getUserPurchases(user.getId());
        return ResponseEntity.ok(purchases);
    }

}

