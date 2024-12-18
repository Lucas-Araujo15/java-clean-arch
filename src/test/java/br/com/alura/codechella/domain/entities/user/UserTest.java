package br.com.alura.codechella.domain.entities.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class UserTest {
    @Test
    public void it_should_not_be_able_to_register_user_with_invalid_cpf() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("Adriano Ano", "adriano@email.com", "123456789-10", LocalDate.now()));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("Adriano Ano", "adriano@email.com", "123456.789-10", LocalDate.now()));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("Adriano Ano", "adriano@email.com", "", LocalDate.now()));
    }

    @Test
    public void it_should_be_able_to_create_user_with_factory() {
        var factory = new UserFactory();
        var user = factory.withNameCpfDateOfBirth("Adriano Ano", "123.456.789-10", LocalDate.parse("1994-05-01"));

        Assertions.assertEquals("Adriano Ano", user.getName());

        user = factory.includesAddress("Rua do Apito", "12365-485", 22, "Javalópolis", "São Paulo", "Bairro Central");

        Assertions.assertEquals("Javalópolis", user.getAddress().getCity());
    }

    @Test
    public void it_should_not_be_able_to_register_an_underage_user() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("Amanda Anda", "amanda@email.com", "147.784.946-85", LocalDate.parse("2020-08-03")));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("Lucas Cas", "lucas@email.com", "451.658.675-45", LocalDate.parse("2018-12-10")));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("Rodrigo Drigo", "rodrigo@email.com", "574.778.247-54", LocalDate.parse("2007-12-18")));
    }
}
