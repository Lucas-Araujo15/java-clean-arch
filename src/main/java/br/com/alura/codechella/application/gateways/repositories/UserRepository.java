package br.com.alura.codechella.application.gateways.repositories;

import br.com.alura.codechella.domain.entities.User;

import java.util.List;

public interface UserRepository {
    User save(User user);
    List<User> listAll();
}
