package pro.sky.adsonlineapp.repository;

import org.springframework.stereotype.Repository;
import pro.sky.adsonlineapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    User findByUsername(String username);

    boolean existsByEmail(String email);
}