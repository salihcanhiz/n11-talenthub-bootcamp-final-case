package com.salihcanhiz.finalcase.request;

import com.salihcanhiz.finalcase.enums.Rate;
import jakarta.validation.constraints.NotBlank;


public record CommentSaveRequest(String restaurantId,
                                 String text,
                                @NotBlank Rate rate) {
}
