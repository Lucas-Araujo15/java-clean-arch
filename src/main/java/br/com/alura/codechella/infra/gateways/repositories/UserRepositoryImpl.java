package br.com.alura.codechella.infra.gateways.repositories;

import br.com.alura.codechella.application.gateways.repositories.UserRepository;
import br.com.alura.codechella.domain.entities.user.User;
import br.com.alura.codechella.infra.gateways.mappers.UserMapper;
import br.com.alura.codechella.infra.persistence.repositories.UserJpaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository jpaRepository;
    private final UserMapper mapper;

    @Override
    public User save(User user) {
        var model = mapper.toModel(user);
        var savedUser = jpaRepository.save(model);
        return mapper.toDomain(savedUser);
    }

    @Override
    public List<User> listAll() {
        return List.of();
    }
}

