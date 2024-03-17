package com.salihcanhiz.finalcase.request;

import com.salihcanhiz.finalcase.enums.Rate;

import jakarta.validation.constraints.NotNull;


public record CommentSaveRequest(String restaurantId,
                                 String text,
                                @NotNull Rate rate) {
}
