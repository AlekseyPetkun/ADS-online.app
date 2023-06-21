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
    @Query("UPDATE User u SET " +
            "u.password = :newPassword " +
            "WHERE u.id = :id")
    User updatePassword(
            @Param("id") Integer id,
            @Param("newPassword") String newPassword);

    @Modifying
    @Query("UPDATE User u SET " +
            "u.firstName = :first_name, " +
            "u.lastName = :last_name," +
            "u.phone = :phone," +
            "u.email = :email," +
            "u.image = :image" +
            " WHERE u.id = :id")
    User updateUser(
            @Param("first_name") String firstName,
            @Param("last_name") String lastName,
            @Param("phone") String phone,
            @Param("email") String email,
            @Param("image") String image,
            @Param("id") Integer id);

}