package br.com.alura.codechella.domain.factories;

import br.com.alura.codechella.domain.valueobjects.Address;
import br.com.alura.codechella.domain.entities.User;

import java.time.LocalDate;

public class UserFactory {
    private User user;

    public User withNameCpfDateOfBirth(String name, String cpf, LocalDate dateOfBirth) {
        this.user = new User(name, null, cpf, dateOfBirth);
        return this.user;
    }

    public User includesAddress(String street, String zipCode, Integer number, String city, String state, String neighborhood) {
        this.user = new User();
        this.user.setAddress(new Address(street, zipCode, number, city, state, neighborhood));
        return this.user;
    }
}