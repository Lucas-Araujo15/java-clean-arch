package br.com.alura.codechella.infra.controllers;

import br.com.alura.codechella.application.usecases.user.CreateUserUseCase;
import br.com.alura.codechella.application.usecases.user.ListAllUsersUseCase;
import br.com.alura.codechella.domain.entities.User;
import br.com.alura.codechella.infra.controllers.dtos.user.input.UserInputDTO;
import br.com.alura.codechella.infra.controllers.dtos.user.output.UserOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final ListAllUsersUseCase listAllUsersUseCase;

    @PostMapping
    public UserOutputDTO createUser(@RequestBody UserInputDTO input) {
        var savedUser = createUserUseCase.execute(new User(input.name(), input.email(), input.cpf(), input.dateOfBirth()));
        return new UserOutputDTO(savedUser.getCpf(), savedUser.getName(), savedUser.getDateOfBirth(), savedUser.getEmail());
    }

    @GetMapping
    public List<UserOutputDTO> listAllUsers() {
        return listAllUsersUseCase.execute().stream().map(
                u -> new UserOutputDTO(u.getCpf(), u.getName(), u.getDateOfBirth(), u.getEmail())
        ).toList();
    }
}
