package br.com.alura.codechella.infra.controllers.dtos.user.output;

import java.time.LocalDate;

public record UserOutputDTO(
        String cpf,
        String name,
        LocalDate dateOfBirth,
        String email
) {
}
