package com.platzi.pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @Column(name = "id_customer",nullable = false,length = 15)
    private String idCustomer;

    @Column(nullable = false,length = 60)
    private String name;

    @Column(length = 100)
    private String address;

    @Column(nullable = false,length = 50,unique = true)
    private String email;

    @Column(length = 20,name = "phone_number")
    private String phoneNumber;

}
