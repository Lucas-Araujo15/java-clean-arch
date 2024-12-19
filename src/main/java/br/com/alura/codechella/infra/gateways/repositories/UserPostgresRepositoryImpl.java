package br.com.alura.codechella.infra.gateways.repositories;

import br.com.alura.codechella.application.dto.user.input.UpdateUserInputDTO;
import br.com.alura.codechella.application.gateways.repositories.UserRepository;
import br.com.alura.codechella.domain.entities.User;
import br.com.alura.codechella.infra.gateways.mappers.UserMapper;
import br.com.alura.codechella.infra.persistence.repositories.UserJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserPostgresRepositoryImpl implements UserRepository {
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
        return jpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void update(Long id, UpdateUserInputDTO input) {
        var registeredUser = jpaRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        if (input.name() != null) registeredUser.setName(input.name());
        if (input.cpf() != null) registeredUser.setCpf(input.cpf());
        if (input.email() != null) registeredUser.setEmail(input.email());
        if (input.dateOfBirth() != null) registeredUser.setDateOfBirth(input.dateOfBirth());

        jpaRepository.save(registeredUser);
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public User findById(Long id) {
        var userFound = jpaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return mapper.toDomain(userFound);
    }
}

