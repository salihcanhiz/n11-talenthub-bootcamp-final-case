package com.salihcanhiz.finalcase.request;

import com.salihcanhiz.finalcase.enums.Rate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record CommentUpdateRequest(Long id,
                                   String text,
                                   @NotNull Rate rate) {
}
