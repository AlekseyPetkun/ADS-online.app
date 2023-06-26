package pro.sky.adsonlineapp.service;

import org.springframework.web.multipart.MultipartFile;
import pro.sky.adsonlineapp.dto.AdsDto;
import pro.sky.adsonlineapp.dto.CreateAds;
import pro.sky.adsonlineapp.dto.FullAds;
import pro.sky.adsonlineapp.dto.ResponseWrapperAds;

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
     * @param dto         тело запроса
     * @param image       картинка товара
     * @param userDetails информация о пользователе
     * @return информация об объявлении
     */
    AdsDto addAd(CreateAds dto, MultipartFile image, String userDetails);

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
     * @param id          идентификатор объявления
     * @param userDetails информация о пользователе
     * @return true or false
     */
    boolean deleteAdById(Integer id, String userDetails);

    /**
     * Обновить информацию об объявлении по id
     *
     * @param id          идентификатор объявления
     * @param dto         тело изменения
     * @param userDetails информация о пользователе
     * @return информация об объявлении
     */
    AdsDto updateAdsById(Integer id, CreateAds dto, String userDetails);

    /**
     * Получить объявления авторизованного пользователя
     *
     * @param userDetails информация о пользователе
     * @return объявления пользователя
     */
    ResponseWrapperAds getAdsMe(String userDetails);

    /**
     * Поиск объявлений по названию
     *
     * @param description название объявления
     * @return найденные объявления
     */
    ResponseWrapperAds findByDescriptionAd(String description);

    byte[] getImageById(String id);

    boolean updateAdImage(Integer id, MultipartFile image);
}
