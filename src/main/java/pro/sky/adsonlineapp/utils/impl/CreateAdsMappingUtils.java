package pro.sky.adsonlineapp.utils.impl;

import org.springframework.stereotype.Service;
import pro.sky.adsonlineapp.dto.CreateAds;
import pro.sky.adsonlineapp.model.Ad;
import pro.sky.adsonlineapp.model.User;
import pro.sky.adsonlineapp.utils.MappingUtils;

/**
 * Бизнес-логика по маппингу объявлений (CreateAds).
 */
@Service
public class CreateAdsMappingUtils {

    public CreateAds mapToDto(Ad entity) {

        CreateAds dto = new CreateAds();
        dto.setDescription(entity.getDescription());
        dto.setTitle(entity.getTitle());
        dto.setPrice(entity.getPrice());

        return dto;
    }

    public Ad mapToEntity(CreateAds dto) {

        Ad adsEntity = new Ad();
        adsEntity.setDescription(dto.getDescription());
        adsEntity.setTitle(dto.getTitle());
        adsEntity.setPrice(dto.getPrice());

        return adsEntity;
    }
}
