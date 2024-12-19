package br.com.alura.codechella.application.usecases.user;

import br.com.alura.codechella.application.dto.user.input.UpdateUserInputDTO;
import br.com.alura.codechella.application.gateways.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateUserUseCase {
    private final UserRepository repository;

    public void execute(Long id, UpdateUserInputDTO input) {
        repository.update(id, input);
    }
}
