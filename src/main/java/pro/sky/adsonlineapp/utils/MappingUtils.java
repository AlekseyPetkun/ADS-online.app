package pro.sky.adsonlineapp.utils;

import pro.sky.adsonlineapp.dto.AdsDto;
import pro.sky.adsonlineapp.dto.CreateAds;
import pro.sky.adsonlineapp.model.Ad;
import pro.sky.adsonlineapp.model.User;

/**
 * Сервис по работе с маппингом.
 *
 * @param <T>
 * @param <R>
 */
public interface MappingUtils<T, R> {

    /**
     * Маппим сущность в дто
     *
     * @param entity сущность
     * @return дто
     */
    T mapToDto(R entity);

    /**
     * Маппим дто в сущность
     *
     * @param dto дто
     * @return сущность
     */
    R mapToEntity(T dto);
}
