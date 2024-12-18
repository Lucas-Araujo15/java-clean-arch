package br.com.alura.codechella.infra.persistence;

import br.com.alura.codechella.domain.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
