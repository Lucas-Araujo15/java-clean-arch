package br.com.alura.codechella.application.usecases.user;

import br.com.alura.codechella.application.gateways.user.UserRepository;
import br.com.alura.codechella.domain.entities.user.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateUserUseCase {
    private final UserRepository repository;

    public User execute(User user) {
        return repository.save(user);
    }
}
