package com.platzi.pizzeria.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pizzas_order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PizzaOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order",nullable = false)
    private Integer idOrder;

    @Column(nullable = false,columnDefinition = "DATETIME")
    private LocalDateTime date;

    @Column(nullable = false,columnDefinition = "DECIMAL(6,2)")
    private Double total;

    @Column(nullable = false,columnDefinition = "CHAR(1)")
    private String method;

    @Column(name = "aditional_notes",length = 200)
    private String aditionalNotes;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id",insertable = false,updatable = false)
    @JsonIgnore
    private Customer customer;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "pizzaOrder")
    private List<OrderItem> orderItems;
}
