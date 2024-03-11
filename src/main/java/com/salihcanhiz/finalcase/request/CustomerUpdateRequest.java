package com.salihcanhiz.finalcase.request;

import java.time.LocalDate;

public record CustomerUpdateRequest(Long id,
                                    String name,
                                    String surname,
                                    LocalDate birthDate,
                                    String phoneNumber,
                                    String email) {

}
