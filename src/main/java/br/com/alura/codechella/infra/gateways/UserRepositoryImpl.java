package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.application.gateways.user.UserRepository;
import br.com.alura.codechella.domain.entities.user.User;
import br.com.alura.codechella.infra.persistence.repositories.UserJpaRepository;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private UserJpaRepository jpaRepository;

    @Override
    public User save(User user) {
        return jpaRepository.save(user);
    }

    @Override
    public List<User> listAll() {
        return List.of();
    }
}
