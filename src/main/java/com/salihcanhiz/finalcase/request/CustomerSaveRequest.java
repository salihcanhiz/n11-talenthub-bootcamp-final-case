package com.salihcanhiz.finalcase.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record CustomerSaveRequest(@NotBlank @Length(min = 1, max = 100) String name,
                                  @NotBlank String surname,
                                  @NotNull @Past LocalDate birthDate,
                                  @NotNull String username,
                                  @NotBlank String identityNo,
                                  @NotBlank String password,
                                  @NotBlank String phoneNumber,
                                  @NotBlank @Email String email,
                                  @NotBlank double longitude,
                                  @NotBlank double latitude) {

}
