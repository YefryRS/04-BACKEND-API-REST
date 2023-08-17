package com.platzi.pizzeria.controller;

import com.platzi.pizzeria.persistence.entity.PizzaOrder;
import com.platzi.pizzeria.service.PizzaOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class PizzaOrderController {
    private final PizzaOrderService orderService;

    @Autowired
    public PizzaOrderController(PizzaOrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<PizzaOrder>> getAll() {
        return ResponseEntity.ok(orderService.getAll());
    }
    @GetMapping("/today")
    public ResponseEntity<List<PizzaOrder>> getTodayOrders() {
        return ResponseEntity.ok(orderService.getTodayOrders());
    }
    @GetMapping("/outside")
    public ResponseEntity<List<PizzaOrder>> getOutsideOrders() {
        return ResponseEntity.ok(orderService.getOutsideOrders());
    }
    @GetMapping("/customer/{id}")
    public ResponseEntity<List<PizzaOrder>> getCustomerOrders(@PathVariable String id) {
        return ResponseEntity.ok(orderService.getCustomerOrders(id));
    }

}
