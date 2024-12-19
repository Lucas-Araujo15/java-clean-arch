package br.com.alura.codechella.application.usecases.user;

import br.com.alura.codechella.application.gateways.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteUserByIdUseCase {
    private final UserRepository repository;

    public void execute(Long id) {
        repository.delete(id);
    }
}
