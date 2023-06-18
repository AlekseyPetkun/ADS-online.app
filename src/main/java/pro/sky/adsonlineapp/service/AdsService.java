package pro.sky.adsonlineapp.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;
import pro.sky.adsonlineapp.dto.AdsDto;
import pro.sky.adsonlineapp.dto.CreateAds;
import pro.sky.adsonlineapp.dto.FullAds;
import pro.sky.adsonlineapp.dto.ResponseWrapperAds;
import pro.sky.adsonlineapp.model.Ad;

import java.util.List;

/**
 * Сервис по работе с объявлениями.
 */
public interface AdsService {

    /**
     * Получить все объявления
     *
     * @return объявления
     */
    ResponseWrapperAds getAllAds();

    /**
     * Добавить объявление
     *
     * @param dto   тело запроса
     * @param image картинка товара
     * @return информация об объявлении
     */
    AdsDto addAd(CreateAds dto, MultipartFile image);

    /**
     * Получить информацию об объявлении по id
     *
     * @param id идентификатор объявления
     * @return информация об объявлении
     */
    FullAds getFullAdsById(Integer id);

    /**
     * Удалить объявление по id
     *
     * @param id идентификатор объявления
     * @return true or false
     */
    boolean deleteAdById(Integer id);

    /**
     * Обновить информацию об объявлении по id
     *
     * @param id  идентификатор объявления
     * @param dto тело изменения
     * @return информация об объявлении
     */
    AdsDto updateAdsById(Integer id, CreateAds dto);

    /**
     * Получить объявления авторизованного пользователя
     *
     * @return объявления пользователя
     */
    ResponseWrapperAds getAdsMe();

    /**
     * Поиск объявлений по названию
     * @param description название объявления
     * @return найденные объявления
     */
    ResponseWrapperAds findByDescriptionAd(String description);
}
