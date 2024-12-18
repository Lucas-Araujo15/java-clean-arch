package br.com.alura.codechella.infra.controllers;

import br.com.alura.codechella.application.usecases.user.CreateUserUseCase;
import br.com.alura.codechella.domain.entities.User;
import br.com.alura.codechella.infra.controllers.dtos.user.input.UserInputDTO;
import br.com.alura.codechella.infra.controllers.dtos.user.output.UserOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final CreateUserUseCase createUserUseCase;

    @PostMapping
    public UserOutputDTO createUser(@RequestBody UserInputDTO input) {
        var savedUser = createUserUseCase.execute(new User(input.name(), input.email(), input.cpf(), input.dateOfBirth()));
        return new UserOutputDTO(savedUser.getCpf(), savedUser.getName(), savedUser.getDateOfBirth(), savedUser.getEmail());
    }
}
