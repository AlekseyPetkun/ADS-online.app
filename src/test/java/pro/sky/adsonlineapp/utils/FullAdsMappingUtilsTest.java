package pro.sky.adsonlineapp.utils;

import org.junit.jupiter.api.Test;
import pro.sky.adsonlineapp.dto.FullAds;
import pro.sky.adsonlineapp.model.Ad;
import pro.sky.adsonlineapp.model.User;

import static org.junit.jupiter.api.Assertions.*;

class FullAdsMappingUtilsTest {

    @Test
    public void testMapToDto() {

        // Mock ad entity
        Ad entity = new Ad();
        entity.setDescription("Test Description");
        entity.setPrice(100);
        entity.setTitle("Test Title");
        entity.setId(1);
        User author = new User();
        author.setUsername("test@gmail.com");
        author.setFirstName("John");
        author.setLastName("Doe");
        author.setPhone("1234567890");

        entity.setAuthor(author);

        // Map entity to dto
        FullAds dto = new FullAdsMappingUtils().mapToDto(entity);

        // Assert dto fields
        assertEquals(dto.getDescription(), entity.getDescription());
        assertEquals(dto.getPrice(), entity.getPrice());
        assertEquals(dto.getTitle(), entity.getTitle());
        assertEquals(dto.getEmail(), entity.getAuthor().getUsername());
        assertEquals(dto.getAuthorFirstName(), entity.getAuthor().getFirstName());
        assertEquals(dto.getAuthorLastName(), entity.getAuthor().getLastName());
        assertEquals(dto.getPk(), entity.getId());
        assertEquals(dto.getPhone(), entity.getAuthor().getPhone());

        if (entity.getImagePath() != null) {
            assertEquals(dto.getImage(), String.format("/ads/image/%s", entity.getImagePath()));
        } else {
            assertNull(dto.getImage());
        }
    }
}