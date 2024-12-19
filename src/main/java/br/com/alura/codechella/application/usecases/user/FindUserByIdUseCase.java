package br.com.alura.codechella.application.usecases.user;

import br.com.alura.codechella.application.gateways.repositories.UserRepository;
import br.com.alura.codechella.domain.entities.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindUserByIdUseCase {
    private final UserRepository repository;

    public User execute(Long id) {
       return repository.findById(id);
    }
}
