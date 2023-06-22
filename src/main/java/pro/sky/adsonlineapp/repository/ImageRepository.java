package pro.sky.adsonlineapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.adsonlineapp.model.Ad;

import java.util.Optional;


@Repository
public interface ImageRepository extends JpaRepository<Ad, Integer> {


    Optional<Ad> findById(Integer id);
}
