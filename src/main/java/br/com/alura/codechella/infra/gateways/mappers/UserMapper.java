package br.com.alura.codechella.infra.gateways.mappers;

import br.com.alura.codechella.domain.entities.User;
import br.com.alura.codechella.infra.persistence.models.UserModel;

public class UserMapper {
    public UserModel toModel(User entity) {
        return new UserModel(entity.getCpf(), entity.getName(), entity.getDateOfBirth(), entity.getEmail());
    }

    public User toDomain(UserModel model) {
        return new User(model.getName(), model.getEmail(), model.getCpf(), model.getDateOfBirth());
    }
}