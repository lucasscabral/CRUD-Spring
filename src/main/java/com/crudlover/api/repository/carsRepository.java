package com.crudlover.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudlover.api.model.cars;

public interface carsRepository extends JpaRepository<cars, Long> {

}
