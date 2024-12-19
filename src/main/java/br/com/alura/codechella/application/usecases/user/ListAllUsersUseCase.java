package br.com.alura.codechella.application.usecases.user;

import br.com.alura.codechella.application.gateways.repositories.UserRepository;
import br.com.alura.codechella.domain.entities.User;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ListAllUsersUseCase {
    private final UserRepository repository;

    public List<User> execute() {
        return repository.listAll();
    }
}
