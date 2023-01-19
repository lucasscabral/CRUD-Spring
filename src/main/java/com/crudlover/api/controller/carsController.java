package com.crudlover.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudlover.api.dto.carsDTO;
import com.crudlover.api.model.cars;
import com.crudlover.api.repository.carsRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cars")
public class carsController {

  @Autowired
  private carsRepository repository;

  @GetMapping
  public List<cars> getCars() {
    return repository.findAll();
  }

  @PostMapping
  public void createCar(@RequestBody @Valid carsDTO req) {
    repository.save(new cars(req));
  }

  @DeleteMapping("/{id}")
  public void deleteCar(@PathVariable Long id) {
    repository.deleteById(id);
  }

  @PutMapping("/{id}")
  public void updateCar(@PathVariable Long id, @RequestBody @Valid carsDTO req) {
    repository.findById(id).map(car -> {
      car.setAnoModelo(req.anoModelo());
      car.setDataFabricacao(req.dataFabricacao());
      car.setFabricante(req.fabricante());
      car.setValor(req.valor());
      car.setModelo(req.modelo());

      return repository.save(car);
    });
  }

}
