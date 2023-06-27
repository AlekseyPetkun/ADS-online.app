package pro.sky.adsonlineapp.dto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResponseWrapperAdsTest {

    @Test
    public void testResponseWrapperAds() {
        // Arrange
        Integer count = 10;
        List<AdsDto> results = new ArrayList<>();
        results.add(new AdsDto(1, "https://example.com/image.jpg", 1, 100, "Example title"));
        results.add(new AdsDto(1, "https://example.com/image1.jpg", 2, 200, "Example title"));
        results.add(new AdsDto(1, "https://example.com/image2.jpg", 3, 300, "Example title"));
        ResponseWrapperAds responseWrapperAds = new ResponseWrapperAds(count, results);

        // Act
        Integer expectedCount = 10;
        Integer actualCount = responseWrapperAds.getCount();

        List<AdsDto> expectedResults = new ArrayList<>();
        expectedResults.add(new AdsDto(1, "https://example.com/image.jpg", 1, 100, "Example title"));
        expectedResults.add(new AdsDto(1, "https://example.com/image1.jpg", 2, 200, "Example title"));
        expectedResults.add(new AdsDto(1, "https://example.com/image2.jpg", 3, 300, "Example title"));
        List<AdsDto> actualResults = responseWrapperAds.getResults();

        // Assert
        assertEquals(expectedCount, actualCount);
        assertEquals(expectedResults, actualResults);
    }

}