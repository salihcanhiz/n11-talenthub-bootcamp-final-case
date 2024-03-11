package com.salihcanhiz.finalcase.request;

import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record CustomerUpdateRequest(Long id,
                                    String name,
                                    String surname,
                                    @Past LocalDate birthDate,
                                    String phoneNumber,
                                    String email,
                                    double longitude,
                                    double latitude) {

}
