package pro.sky.adsonlineapp.utils;

import org.springframework.stereotype.Service;
import pro.sky.adsonlineapp.dto.AdsDto;
import pro.sky.adsonlineapp.dto.CreateAds;
import pro.sky.adsonlineapp.model.Ad;
import pro.sky.adsonlineapp.model.User;

import java.util.Base64;


/**
 * Бизнес-логика по маппингу объявлений (Ads).
 */
@Service
public class AdsMappingUtils {

    public AdsDto mapToDto(Ad entity) {

        AdsDto dto = new AdsDto();
        dto.setPk(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setPrice(entity.getPrice());
        dto.setImage(entity.getImage().toString());
        //dto.setImage(Base64.getEncoder().encodeToString(entity.getImage()));
        //dto.setImage(UUID.randomUUID().toString());
        dto.setAuthor(entity.getAuthor().getId());

        return dto;
    }

    public Ad mapToEntity(CreateAds dto, User author) {

        Ad adsEntity = new Ad();
        adsEntity.setDescription(dto.getDescription());
        adsEntity.setTitle(dto.getTitle());
        adsEntity.setPrice(dto.getPrice());
        adsEntity.setAuthor(author);
        

        return adsEntity;
    }
}
