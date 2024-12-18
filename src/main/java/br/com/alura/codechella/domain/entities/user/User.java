package br.com.alura.codechella.domain.entities.user;

import br.com.alura.codechella.domain.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
public class User {
    private String name;
    private String email;
    private String cpf;
    private LocalDate dateOfBirth;
    private Address address;

    public User(String name, String email, String cpf, LocalDate dateOfBirth) {
        if (Objects.isNull(cpf) || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}"))
            throw new IllegalArgumentException("CPF no formato inválido");

        var age = Period.between(dateOfBirth, LocalDate.now()).getYears();

        if (age < 18) throw new IllegalArgumentException("Usuário menor de idade");

        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.dateOfBirth = dateOfBirth;
    }
}
