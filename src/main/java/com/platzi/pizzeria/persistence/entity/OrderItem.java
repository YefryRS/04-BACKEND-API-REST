package com.platzi.pizzeria.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "orders_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    @EmbeddedId /* Clave primaria compuesta */
    private OrderItemPK id;

    @Column(nullable = false,columnDefinition = "DECIMAL(2,1)")
    private Double quantity;

    @Column(nullable = false,columnDefinition = "DECIMAL(5,2)")
    private Double price;

    @OneToOne
    @JoinColumn(name = "id_pizza",insertable = false,updatable = false)
    private Pizza pizza;

    @ManyToOne
    @JoinColumn(name = "id_pizza",insertable = false,updatable = false)
    @JsonIgnore
    private PizzaOrder pizzaOrder;
}
