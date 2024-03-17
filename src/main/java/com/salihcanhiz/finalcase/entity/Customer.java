package com.salihcanhiz.finalcase.entity;

import com.salihcanhiz.finalcase.enums.EnumStatus;
import com.salihcanhiz.finalcase.general.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.validator.constraints.Length;


import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CUSTOMER")
public class Customer extends BaseEntity {

    @SequenceGenerator(name = "Customer", sequenceName = "CUSTOMER_ID_SEQ")
    @Id
    @GeneratedValue(generator = "Customer",strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @Length(min = 1, max = 100)
    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @NotNull
    @Column(name = "SURNAME", length = 100, nullable = false)
    private String surname;

    @Past
    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    @Column(name = "PHONE_NUMBER", length = 10)
    private String phoneNumber;

    @NotBlank(message = "PASSWORD CANNOT BE BLANK!")
    @Column(name = "PASSWORD", length = 400, nullable = false)
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", length = 30, nullable = false)
    private EnumStatus status;

    @Email
    @NotBlank
    @Column(name = "EMAIL", length = 100, nullable = false)
    private String email;

    @Column(name = "LONGITUDE", length = 80)
    private double longitude;

    @Column(name = "LATITUDE", length = 80)
    private double latitude;





}
