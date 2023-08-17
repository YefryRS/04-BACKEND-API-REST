package com.platzi.pizzeria.persistence.repository;

import com.platzi.pizzeria.persistence.entity.Pizza;
import com.platzi.pizzeria.service.dto.UpdatePizzaPriceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza,Integer> {
    // Query method: lo convierte a consulta sql en tiempo de ejecucion
    List<Pizza> findAllByAvailableTrueOrderByPrice();
    Optional<Pizza> findFirstByAvailableTrueAndNameIgnoreCase(String name);
    List<Pizza> findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String description);
    List<Pizza> findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(String description);
    List<Pizza> findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(double price);
    int countByVeganTrue();

    //Modifying, y hacemos uso del dto. No es necesario hacerlo asi, podemos dejarlo como estabamos haciendo anteriormente
    @Query(value = "UPDATE pizzas SET price = :#{#newPizzaPrice.newPrice} WHERE id_pizza = :#{#newPizzaPrice.pizzaId}", nativeQuery = true)
    @Modifying
    void updatePrice(@Param("id")UpdatePizzaPriceDto newPizzaPrice);
}
