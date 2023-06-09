package pro.sky.adsonlineapp.utils.impl;

import org.springframework.stereotype.Service;
import pro.sky.adsonlineapp.dto.FullAds;
import pro.sky.adsonlineapp.model.Ad;
import pro.sky.adsonlineapp.model.User;
import pro.sky.adsonlineapp.utils.MappingUtils;

/**
 * Бизнес-логика по маппингу объявлений (FullAds).
 */
@Service
public class FullAdsMappingUtilsImpl implements MappingUtils<FullAds, Ad> {

    @Override
    public FullAds mapToDto(Ad entity) {
        FullAds dto = new FullAds();
        dto.setDescription(entity.getDescription());
        dto.setPrice(entity.getPrice());
        dto.setTitle(entity.getTitle());
        dto.setEmail(entity.getAuthor().getEmail());
        dto.setAuthorFirstName(entity.getAuthor().getFirstName());
        dto.setAuthorLastName(entity.getAuthor().getLastName());
        dto.setPk(entity.getPk());
        dto.setPhone(entity.getAuthor().getPhone());
//        dto.setImage(entity.getPicture);

        return dto;
    }

    @Override
    public Ad mapToEntity(FullAds dto) {

        User author = new User(dto.getAuthorFirstName(), dto.getAuthorLastName(), dto.getEmail(), dto.getPhone());
        Ad adsEntity = new Ad();
        adsEntity.setDescription(dto.getDescription());
        adsEntity.setPk(dto.getPk());
        adsEntity.setPrice(dto.getPrice());
        adsEntity.setTitle(dto.getTitle());
        adsEntity.setAuthor(author);
//        adsEntity.setImage(dto.getImage());

        return adsEntity;
    }
}
