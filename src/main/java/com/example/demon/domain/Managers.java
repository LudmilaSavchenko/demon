package com.example.demon.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Table(name = "managers", schema = "customers")
@Getter
public class Managers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name_ru", nullable = false)
    private String firstNameRu;


    @Column(name = "last_name_ru", nullable = false)
    private String lastNameRu;

    @Column(name = "middle_name_ru", nullable = false)
    private String middleNameRu;

    @Column(name = "first_name_en", nullable = false)
    private String firstNameEn;


    @Column(name = "last_name_en", nullable = false)
    private String lastNameEn;

    @Column(name = "middle_name_en", nullable = false)
    private String middleNameEn;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "time_zone")
    private String timeZone;

    @Override
    public String toString() {
        return "Managers{" +
                "firstName='" + firstNameRu + '\'' +
                '}';
    }

}

