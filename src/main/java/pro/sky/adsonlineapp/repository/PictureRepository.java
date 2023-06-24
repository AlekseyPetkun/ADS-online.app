package pro.sky.adsonlineapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.adsonlineapp.model.Picture;

@Repository
public interface PictureRepository extends JpaRepository<Picture, String> {
    Picture saveAndFlush(Picture picture);
}
