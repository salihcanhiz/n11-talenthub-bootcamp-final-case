package com.salihcanhiz.finalcase.dto;

import com.salihcanhiz.finalcase.enums.Rate;

public record CommentDTO(Long id,
                         String restaurantId,
                         String text,
                         Rate rate) {
}
