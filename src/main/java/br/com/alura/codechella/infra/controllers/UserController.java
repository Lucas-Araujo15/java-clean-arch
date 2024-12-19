package br.com.alura.codechella.infra.controllers;

import br.com.alura.codechella.application.usecases.user.CreateUserUseCase;
import br.com.alura.codechella.application.usecases.user.DeleteUserByIdUseCase;
import br.com.alura.codechella.application.usecases.user.FindUserByIdUseCase;
import br.com.alura.codechella.application.usecases.user.ListAllUsersUseCase;
import br.com.alura.codechella.application.usecases.user.UpdateUserUseCase;
import br.com.alura.codechella.domain.entities.User;
import br.com.alura.codechella.application.dto.user.input.UpdateUserInputDTO;
import br.com.alura.codechella.application.dto.user.input.UserInputDTO;
import br.com.alura.codechella.application.dto.user.output.UserOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserByIdUseCase deleteUserByIdUseCase;
    private final FindUserByIdUseCase findUserByIdUseCase;

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

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody UpdateUserInputDTO input) {
        updateUserUseCase.execute(id, input);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deleteUserByIdUseCase.execute(id);
    }

    @GetMapping("/{id}")
    public UserOutputDTO findById(@PathVariable Long id) {
        var userFound = findUserByIdUseCase.execute(id);
        return new UserOutputDTO(userFound.getCpf(), userFound.getName(), userFound.getDateOfBirth(), userFound.getEmail());
    }
}
