package pro.sky.adsonlineapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.adsonlineapp.model.Ads;


@Repository
public interface AdsRepository extends JpaRepository<Ads, Integer> {


}
