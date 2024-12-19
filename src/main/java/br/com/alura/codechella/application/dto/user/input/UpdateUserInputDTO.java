package br.com.alura.codechella.application.dto.user.input;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public record UpdateUserInputDTO(
        String name,
        String cpf,
        String email,
        LocalDate dateOfBirth
) {
}
