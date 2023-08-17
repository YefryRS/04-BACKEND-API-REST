package com.platzi.pizzeria.service;

import com.platzi.pizzeria.persistence.entity.PizzaOrder;
import com.platzi.pizzeria.persistence.repository.PizzaOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class PizzaOrderService {
    private final PizzaOrderRepository orderRepository;

    private static final String DELIVERY = "D";
    private static final String CARRYOUT = "C";
    private static final String ON_SITE = "S";

    @Autowired
    public PizzaOrderService(PizzaOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<PizzaOrder> getTodayOrders() {
        LocalDateTime today = LocalDate.now().atTime(0,0);
        return orderRepository.findAllByDateAfter(today);
    }


    public List<PizzaOrder> getAll() {
        List<PizzaOrder> orders = orderRepository.findAll();
        orders.forEach(order -> System.out.println(order.getCustomer().getName()));
        return orderRepository.findAll();
    }
    public List<PizzaOrder> getOutsideOrders() {
        List<String> methods = Arrays.asList(DELIVERY,CARRYOUT);
        return orderRepository.findAllByMethodIn(methods);
    }

    public List<PizzaOrder> getCustomerOrders(String idCustomer) {
        return orderRepository.findCustomerOrders(idCustomer);
    }

}
