package br.com.alura.codechella.application.gateways.repositories;

import br.com.alura.codechella.application.dto.user.input.UpdateUserInputDTO;
import br.com.alura.codechella.domain.entities.User;

import java.util.List;

public interface UserRepository {
    User save(User user);
    List<User> listAll();
    void update(Long id, UpdateUserInputDTO input);
    void delete(Long id);
    User findById(Long id);
}
