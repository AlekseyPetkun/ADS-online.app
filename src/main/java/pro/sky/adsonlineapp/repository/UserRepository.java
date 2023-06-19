package pro.sky.adsonlineapp.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pro.sky.adsonlineapp.model.Comment;
import pro.sky.adsonlineapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    @Modifying
    @Query(value = "UPDATE users SET password = :newPassword WHERE password = :currentPassword", nativeQuery=true)
    User updatePassword(
            @Param("currentPassword") String currentPassword,
            @Param("newPassword") String newPassword);

}