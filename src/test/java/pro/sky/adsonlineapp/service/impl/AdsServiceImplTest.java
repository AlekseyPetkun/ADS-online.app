package pro.sky.adsonlineapp.service.impl;

import org.junit.jupiter.api.Test;
import pro.sky.adsonlineapp.dto.AdsDto;
import pro.sky.adsonlineapp.dto.ResponseWrapperAds;
import pro.sky.adsonlineapp.model.Ad;
import pro.sky.adsonlineapp.repository.AdsRepository;
import pro.sky.adsonlineapp.repository.UserRepository;
import pro.sky.adsonlineapp.service.PictureService;
import pro.sky.adsonlineapp.service.ValidationService;
import pro.sky.adsonlineapp.utils.AdsMappingUtils;
import pro.sky.adsonlineapp.utils.FullAdsMappingUtils;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AdsServiceImplTest {

    @Test
    public void testGetAllAds() {

        ValidationService validationServiceMock = mock(ValidationService.class);
        AdsRepository adsRepositoryMock = mock(AdsRepository.class);
        UserRepository userRepositoryMock = mock(UserRepository.class);
        AdsMappingUtils adsMappingUtilsMock = mock(AdsMappingUtils.class);
        FullAdsMappingUtils fullAdsMappingUtilsMock = mock(FullAdsMappingUtils.class);
        PictureService pictureServiceMock = mock(PictureService.class);
        AdsServiceImpl adsService = new AdsServiceImpl(validationServiceMock, adsRepositoryMock, userRepositoryMock, adsMappingUtilsMock, fullAdsMappingUtilsMock, pictureServiceMock);

        AdsDto adsDto1 = new AdsDto();
        AdsDto adsDto2 = new AdsDto();
        List<AdsDto> adsDtoList = Arrays.asList(adsDto1, adsDto2);

        when(adsRepositoryMock.findAll()).thenReturn(Arrays.asList(new Ad(), new Ad()));
        when(adsMappingUtilsMock.mapToDto(any(Ad.class))).thenReturn(new AdsDto());

        ResponseWrapperAds responseWrapperAds = adsService.getAllAds();

        assertEquals(2, responseWrapperAds.getCount());
        assertEquals(adsDtoList, responseWrapperAds.getResults());
    }

}