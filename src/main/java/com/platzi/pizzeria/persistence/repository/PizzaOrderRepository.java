package com.platzi.pizzeria.persistence.repository;

import com.platzi.pizzeria.persistence.entity.PizzaOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PizzaOrderRepository extends JpaRepository<PizzaOrder,Integer> {
    // Query methdos
    List<PizzaOrder> findAllByDateAfter(LocalDateTime date);
    List<PizzaOrder> findAllByMethodIn(List<String> methods);

    //Query con sql nativos: la sintaxis y los nombres como estan en la base de datos
    @Query(value = "SELECT * FROM pizza_order WHERE id_customer = :id", nativeQuery = true)
    List<PizzaOrder> findCustomerOrders(@Param("id") String idCustomer);

    //forma 2: ?1 => no le colocamos el @Param,y especificamos que es el primer parametro
    @Query(value = "SELECT * FROM pizza_order WHERE id_customer = ?1", nativeQuery = true)
    List<PizzaOrder> findCustomerOrders2(String idCustomer);
}
