package com.example.demon.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "customers", schema = "customers")
public class Customers  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cnum", nullable = false)
    private Long cnum;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "created_date", nullable = false)
    private LocalDate createdDate;

    @Column(name = "update_date", nullable = false)
    private LocalDate  updateDate;

}
