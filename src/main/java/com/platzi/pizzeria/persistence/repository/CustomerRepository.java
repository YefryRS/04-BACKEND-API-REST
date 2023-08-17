package com.platzi.pizzeria.persistence.repository;

import com.platzi.pizzeria.persistence.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {

    //JPQL
    @Query(value = "SELECT c FROM Customer c WHERE c.phoneNumber = :phone")
    Customer findByPhone(@Param("phone") String phone);
}
