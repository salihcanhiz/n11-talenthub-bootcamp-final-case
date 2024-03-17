package com.salihcanhiz.finalcase.request;

import com.salihcanhiz.finalcase.enums.Rate;
import jakarta.validation.constraints.NotBlank;


public record CommentUpdateRequest(Long id,
                                   String text,
                                   @NotBlank Rate rate) {
}
