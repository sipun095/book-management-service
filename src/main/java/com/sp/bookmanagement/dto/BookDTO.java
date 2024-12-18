package com.sp.bookmanagement.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private String description;
    private BigDecimal price;
    private String isbn;
    private Date publicationDate;
    private String categoryName; // Simplifies the category lookup
    private int stockQuantity;
    private String imgUrl;

}
