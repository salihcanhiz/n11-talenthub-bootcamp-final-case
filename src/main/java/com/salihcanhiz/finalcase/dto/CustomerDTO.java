package com.salihcanhiz.finalcase.dto;

import com.salihcanhiz.finalcase.enums.EnumStatus;

import java.time.LocalDate;

public record CustomerDTO(Long id,
                          String name,
                          String surname,
                          LocalDate birthDate,
                          String username,
                          String identityNo,
                          String phoneNumber,
                          String email,
                          EnumStatus status){
}
