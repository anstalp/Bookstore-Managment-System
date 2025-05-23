package com.bookstore.bookstore.user.purchase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseResponse {
    private Long id;
    private String bookTitle;
    private String bookAuthor;
    private Integer quantity;
    private Double totalPrice;
    private LocalDateTime purchaseDate;
}

