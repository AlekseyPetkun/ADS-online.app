package pro.sky.adsonlineapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pro.sky.adsonlineapp.dto.CreateAds;
import pro.sky.adsonlineapp.model.Ad;
import pro.sky.adsonlineapp.model.User;

import java.util.List;


@Repository
public interface AdsRepository extends JpaRepository<Ad, Integer> {

    /**
     * Поиск объявления по названию
     * @param description название объявления
     * @return список найденных объявлений
     */
    List<Ad> findByDescriptionContainingIgnoreCase(String description);

    /**
     * Поиск объявлений по автору
     * @param author автор объявления
     * @return список найденных объявлений
     */
    List<Ad> findByAuthor(User author);
}
