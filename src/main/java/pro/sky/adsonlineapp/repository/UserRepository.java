package pro.sky.adsonlineapp.repository;

import pro.sky.adsonlineapp.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}