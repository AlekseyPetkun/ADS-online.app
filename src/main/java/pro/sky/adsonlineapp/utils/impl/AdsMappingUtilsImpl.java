package pro.sky.adsonlineapp.utils.impl;

import org.springframework.stereotype.Service;
import pro.sky.adsonlineapp.dto.AdsDto;
import pro.sky.adsonlineapp.model.Ads;
import pro.sky.adsonlineapp.utils.MappingUtils;

/**
 * Бизнес-логика по маппингу объявлений.
 */
@Service
public class AdsMappingUtilsImpl implements MappingUtils<AdsDto, Ads> {

    @Override
    public AdsDto mapToDto(Ads entity) {
        AdsDto dto = new AdsDto();
        dto.setPk(entity.getPk());
        dto.setTitle(entity.getTitle());
        dto.setPrice(entity.getPrice());
        dto.setImage(entity.getImage());
        dto.setAuthor(entity.getAuthor());
        return dto;
    }

    @Override
    public Ads mapToEntity(AdsDto dto) {
        Ads adsEntity = new Ads();
        adsEntity.setPk(dto.getPk());
        adsEntity.setTitle(dto.getTitle());
        adsEntity.setPrice(dto.getPrice());
        adsEntity.setImage(dto.getImage());
        adsEntity.setAuthor(dto.getAuthor());
        return adsEntity;
    }
}
