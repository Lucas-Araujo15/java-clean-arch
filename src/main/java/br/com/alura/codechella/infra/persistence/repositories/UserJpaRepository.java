package br.com.alura.codechella.infra.persistence.repositories;

import br.com.alura.codechella.infra.persistence.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserModel, Long> {
}
