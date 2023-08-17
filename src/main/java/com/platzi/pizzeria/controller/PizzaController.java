package com.platzi.pizzeria.controller;

import com.platzi.pizzeria.persistence.entity.Pizza;
import com.platzi.pizzeria.service.PizzaService;
import com.platzi.pizzeria.service.dto.UpdatePizzaPriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {
    private final PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public ResponseEntity<List<Pizza>> getAll() {
        return ResponseEntity.ok(pizzaService.getAll());
    }

    @GetMapping("/{idPizza}")
    public ResponseEntity<Optional<Pizza>> get(@PathVariable Integer idPizza) {
        return ResponseEntity.ok(pizzaService.get(idPizza));
    }

    @GetMapping("/available")
    public ResponseEntity<List<Pizza>> getAvailable() {
        return ResponseEntity.ok(pizzaService.getAvailable());
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<Optional<Pizza>> getByName(@PathVariable String name) {
        return ResponseEntity.ok(pizzaService.getByName(name));
    }
    @GetMapping("/with/{ingredient}")
    public ResponseEntity<List<Pizza>> getWith(@PathVariable String ingredient) {
        return ResponseEntity.ok(pizzaService.getWith(ingredient));
    }
    @GetMapping("/with/{ingredient}")
    public ResponseEntity<List<Pizza>> getWithout(@PathVariable String ingredient) {
        return ResponseEntity.ok(pizzaService.getWithout(ingredient));
    }
    @GetMapping("/cheapest/{price}")
    public ResponseEntity<List<Pizza>> getCheapeastPizzas(@PathVariable double price) {
        return ResponseEntity.ok(pizzaService.getCheapest(price));
    }

    @PostMapping
    public ResponseEntity<Pizza> get(@RequestBody Pizza pizza) {
        if(pizza.getIdPizza() == null || pizzaService.exist(pizza.getIdPizza())) {
            return ResponseEntity.ok(pizzaService.save(pizza));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Pizza> update(@RequestBody Pizza pizza) {
        if(pizza.getIdPizza() != null && pizzaService.exist(pizza.getIdPizza())) {
            return ResponseEntity.ok(pizzaService.save(pizza));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/price")
    public ResponseEntity<Void> updatePrice(@RequestBody UpdatePizzaPriceDto dto) {
        if(pizzaService.exist(dto.getPizzaId())) {
            pizzaService.updatePrice(dto);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{idPizza}")
    public ResponseEntity<Void> delete(@PathVariable Integer idPizza) {
        if(pizzaService.exist(idPizza)) {
            pizzaService.delete(idPizza);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
