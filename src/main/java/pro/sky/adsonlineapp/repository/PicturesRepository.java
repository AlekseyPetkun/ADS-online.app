package pro.sky.adsonlineapp.repository;

import org.springframework.stereotype.Repository;
import pro.sky.adsonlineapp.model.Pictures;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PicturesRepository extends JpaRepository<Pictures, Integer> {

    Pictures findImageByAdsId(Integer id);

    Pictures findImageByUserId(Integer id);
}
