package com.platzi.pizzeria.service;

import com.platzi.pizzeria.persistence.entity.Customer;
import com.platzi.pizzeria.persistence.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;

public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findByPhone(String phone) {
        return customerRepository.findByPhone(phone);
    }
}
