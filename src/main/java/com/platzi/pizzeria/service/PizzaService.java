package com.platzi.pizzeria.service;

import com.platzi.pizzeria.persistence.entity.Pizza;
import com.platzi.pizzeria.persistence.repository.PizzaRepository;
import com.platzi.pizzeria.service.dto.UpdatePizzaPriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {

    private PizzaRepository pizzaRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<Pizza> getAll() {
        return pizzaRepository.findAll();
    }

    // query methods
    public List<Pizza> getAvailable() {
        pizzaRepository.countByVeganTrue();
        return pizzaRepository.findAllByAvailableTrueOrderByPrice();
    }
    public Optional<Pizza> getByName(String name) {
        return  pizzaRepository.findFirstByAvailableTrueAndNameIgnoreCase(name);
    }
    public List<Pizza> getWith(String ingredient) {
        return pizzaRepository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase(ingredient);
    }
    public List<Pizza> getWithout(String ingredient) {
        return pizzaRepository.findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(ingredient);
    }
    public List<Pizza> getCheapest(double price) {
        return pizzaRepository.findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(price);
    }

    public Optional<Pizza> get(Integer id) {
        return pizzaRepository.findById(id);
    }

    public Pizza save(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    public void delete(int idPizza) {
        pizzaRepository.deleteById(idPizza);
    }

    @Transactional // De spring framework
    public void updatePrice(UpdatePizzaPriceDto dto) {
        pizzaRepository.updatePrice(dto);
    }

    public boolean exist(int idPizza) {
        return pizzaRepository.existsById(idPizza);
    }

}
