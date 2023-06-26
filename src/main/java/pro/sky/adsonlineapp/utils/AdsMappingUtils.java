package pro.sky.adsonlineapp.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pro.sky.adsonlineapp.dto.AdsDto;
import pro.sky.adsonlineapp.dto.CreateAds;
import pro.sky.adsonlineapp.model.Ad;
import pro.sky.adsonlineapp.model.User;

/**
 * Бизнес-логика по маппингу объявлений (Ads).
 */
@Service
@Slf4j
public class AdsMappingUtils {

    public AdsDto mapToDto(Ad entity) {

        AdsDto dto = new AdsDto();
        dto.setPk(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setPrice(entity.getPrice());
        dto.setImage(entity.getImagePath());
        dto.setAuthor(entity.getAuthor().getId());
        dto.setImage("/ads/image/" + entity.getImagePath());

        log.info("AdsMappingUtils.mapToDto: dto.getImage = {}", dto.getImage());

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
