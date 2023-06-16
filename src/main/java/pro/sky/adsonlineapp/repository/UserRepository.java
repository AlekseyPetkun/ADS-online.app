package pro.sky.adsonlineapp.repository;

import org.springframework.stereotype.Repository;
import pro.sky.adsonlineapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}