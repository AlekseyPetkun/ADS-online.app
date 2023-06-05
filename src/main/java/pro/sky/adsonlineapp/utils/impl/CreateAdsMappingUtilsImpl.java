package pro.sky.adsonlineapp.utils.impl;

import org.springframework.stereotype.Service;
import pro.sky.adsonlineapp.dto.CreateAds;
import pro.sky.adsonlineapp.model.Ads;
import pro.sky.adsonlineapp.utils.MappingUtils;

/**
 * Бизнес-логика по маппингу объявлений (CreateAds).
 */
@Service
public class CreateAdsMappingUtilsImpl implements MappingUtils<CreateAds, Ads> {

    @Override
    public CreateAds mapToDto(Ads entity) {

        CreateAds dto = new CreateAds();
        dto.setDescription(entity.getDescription());
        dto.setTitle(entity.getTitle());
        dto.setPrice(entity.getPrice());

        return dto;
    }

    @Override
    public Ads mapToEntity(CreateAds dto) {

        Ads adsEntity = new Ads();
        adsEntity.setDescription(dto.getDescription());
        adsEntity.setTitle(dto.getTitle());
        adsEntity.setPrice(dto.getPrice());

        return adsEntity;
    }
}
