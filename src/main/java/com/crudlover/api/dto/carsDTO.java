package com.crudlover.api.dto;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

public record carsDTO(
    @NotBlank String modelo,
    @NotBlank String fabricante,
    @Past Date dataFabricacao,
    int valor,
    int anoModelo) {
}
