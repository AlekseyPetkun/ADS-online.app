package pro.sky.adsonlineapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pro.sky.adsonlineapp.dto.CreateAds;
import pro.sky.adsonlineapp.model.Ad;


@Repository
public interface AdsRepository extends JpaRepository<Ad, Integer> {

    /**
     * Изменение объявления по id
     * @param description название объявления
     * @param price цена объявления
     * @param title описание объявления
     * @param id идентификатор объявления
     * @return измененная сущность объявления
     */
    @Query("UPDATE Ad a SET " +
            "a.description = :description, " +
            "a.price = :price," +
            "a.title = :title" +
            " WHERE a.pk = :id")

    Ad updateAdsById(
            @Param("description") String description,
            @Param("price") Integer price,
            @Param("title") String title,
            @Param("id") Integer pk);
}
