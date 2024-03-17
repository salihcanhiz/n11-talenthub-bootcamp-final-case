package com.salihcanhiz.finalcase.dto;

import com.salihcanhiz.finalcase.enums.EnumStatus;
import jakarta.validation.constraints.Email;

import java.time.LocalDate;

public record CustomerDTO(Long id,
                          String name,
                          String surname,
                          LocalDate birthDate,
                          String phoneNumber,
                          String email,
                          EnumStatus status,
                          double longitude,
                          double latitude){
}
