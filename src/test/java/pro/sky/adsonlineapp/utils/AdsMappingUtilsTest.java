package pro.sky.adsonlineapp.utils;

import org.junit.jupiter.api.Test;
import pro.sky.adsonlineapp.dto.AdsDto;
import pro.sky.adsonlineapp.dto.CreateAds;
import pro.sky.adsonlineapp.model.Ad;
import pro.sky.adsonlineapp.model.User;

import static org.junit.jupiter.api.Assertions.*;

class AdsMappingUtilsTest {

    @Test
    void testMapToDto() {
        Ad entity = new Ad();
        entity.setId(1);
        entity.setTitle("Test Ad");
        entity.setPrice(100);
        entity.setImagePath("image.jpg");
        User author = new User();
        author.setId(1);
        entity.setAuthor(author);

        AdsMappingUtils utils = new AdsMappingUtils();

        AdsDto dto = utils.mapToDto(entity);

        assertEquals(dto.getPk(), entity.getId());
        assertEquals(dto.getTitle(), entity.getTitle());
        assertEquals(dto.getPrice(), entity.getPrice());
        assertEquals(dto.getImage(), String.format("/ads/image/%s", entity.getImagePath()));
        assertEquals(dto.getAuthor(), entity.getAuthor().getId());
    }

    @Test
    void testMapToEntity() {
        CreateAds dto = new CreateAds();
        dto.setTitle("Test Ad");
        dto.setPrice(100);
        dto.setDescription("Test Description");
        User author = new User();
        author.setId(1);

        AdsMappingUtils utils = new AdsMappingUtils();

        Ad entity = utils.mapToEntity(dto, author);

        assertEquals(entity.getTitle(), dto.getTitle());
        assertEquals(entity.getPrice(), dto.getPrice());
        assertEquals(entity.getDescription(), dto.getDescription());
        assertEquals(entity.getAuthor(), author);
    }

}