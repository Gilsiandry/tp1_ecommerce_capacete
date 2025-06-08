package br.unitins.tp1.dto.capacete;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record JugularDTO(
    @NotBlank(message = "O tipo de fechamento deve ser informado.")
    @Size(min = 4, max = 40, message = "O tipo de fechamento deve possuir entre 4 a 40 caracteres.")
    String tipoFechamento) {

    }