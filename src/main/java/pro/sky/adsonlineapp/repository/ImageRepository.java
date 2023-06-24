package pro.sky.adsonlineapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.adsonlineapp.model.Picture;
import pro.sky.adsonlineapp.model.User;

public interface ImageRepository  extends JpaRepository<Picture, String> {
}
