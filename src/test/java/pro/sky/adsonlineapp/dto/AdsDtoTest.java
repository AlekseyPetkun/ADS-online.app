package pro.sky.adsonlineapp.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdsDtoTest {

    @Test
    public void testDataClass() {

        AdsDto ads = new AdsDto(1, "https://example.com/image.jpg", 12345, 100, "Example title");
        assertEquals(1, ads.getAuthor());
        assertEquals("https://example.com/image.jpg", ads.getImage());
        assertEquals(12345, ads.getPk());
        assertEquals(100, ads.getPrice());
        assertEquals("Example title", ads.getTitle());
        AdsDto emptyAds = new AdsDto();
        assertNull(emptyAds.getAuthor());
        assertNull(emptyAds.getImage());
        assertNull(emptyAds.getPk());
        assertNull(emptyAds.getPrice());
        assertNull(emptyAds.getTitle());
    }
}