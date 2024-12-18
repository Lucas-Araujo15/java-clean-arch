package br.com.alura.codechella.infra.controllers.dtos.user.input;

import java.time.LocalDate;

public record UserInputDTO(
        String cpf,
        String name,
        LocalDate dateOfBirth,
        String email
) {
}
