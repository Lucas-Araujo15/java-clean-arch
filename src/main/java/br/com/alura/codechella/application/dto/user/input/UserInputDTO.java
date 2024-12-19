package br.com.alura.codechella.application.dto.user.input;

import java.time.LocalDate;

public record UserInputDTO(
        String cpf,
        String name,
        LocalDate dateOfBirth,
        String email
) {
}
