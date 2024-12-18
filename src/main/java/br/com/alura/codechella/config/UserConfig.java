package br.com.alura.codechella.config;

import br.com.alura.codechella.application.gateways.repositories.UserRepository;
import br.com.alura.codechella.application.usecases.user.CreateUserUseCase;
import br.com.alura.codechella.infra.gateways.mappers.UserMapper;
import br.com.alura.codechella.infra.gateways.repositories.UserRepositoryImpl;
import br.com.alura.codechella.infra.persistence.repositories.UserJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    CreateUserUseCase createUser(UserRepository repository) {
        return new CreateUserUseCase(repository);
    }

    @Bean
    UserRepositoryImpl createUserRepositoryImpl(UserMapper mapper, UserJpaRepository repository) {
        return new UserRepositoryImpl(repository, mapper);
    }

    @Bean
    UserMapper createUserMapper() {
        return new UserMapper();
    }
}