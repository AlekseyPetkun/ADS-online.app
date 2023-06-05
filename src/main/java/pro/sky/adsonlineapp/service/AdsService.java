package pro.sky.adsonlineapp.service;

import pro.sky.adsonlineapp.dto.AdsDto;
import pro.sky.adsonlineapp.dto.CreateAds;

import java.util.List;

/**
 * Сервис по работе с объявлениями.
 */
public interface AdsService {

    List<AdsDto> getAllAds();

    AdsDto addAd(CreateAds createAds);
}
