package pro.sky.adsonlineapp.utils.impl;

import org.springframework.stereotype.Service;
import pro.sky.adsonlineapp.dto.AdsDto;
import pro.sky.adsonlineapp.model.Ad;
import pro.sky.adsonlineapp.model.User;
import pro.sky.adsonlineapp.utils.MappingUtils;

/**
 * Бизнес-логика по маппингу объявлений (Ads).
 */
@Service
public class AdsMappingUtilsImpl implements MappingUtils<AdsDto, Ad> {

    @Override
    public AdsDto mapToDto(Ad entity) {

        AdsDto dto = new AdsDto();
        dto.setPk(entity.getPk());
        dto.setTitle(entity.getTitle());
        dto.setPrice(entity.getPrice());
        dto.setImage(entity.getImage());
        dto.setAuthor(entity.getAuthor().getId());

        return dto;
    }

    @Override
    public Ad mapToEntity(AdsDto dto) {

        User author = new User();
        Ad adsEntity = new Ad();
        adsEntity.setPk(dto.getPk());
        adsEntity.setTitle(dto.getTitle());
        adsEntity.setPrice(dto.getPrice());
//        adsEntity.setImage(dto.getImage());
        adsEntity.setAuthor(author);

        return adsEntity;
    }
}
