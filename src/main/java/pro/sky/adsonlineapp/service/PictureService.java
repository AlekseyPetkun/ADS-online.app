package pro.sky.adsonlineapp.service;

import org.springframework.web.multipart.MultipartFile;
import pro.sky.adsonlineapp.model.Picture;

/**
 * Сервис по работе с картинками.
 */
public interface PictureService {

    /**
     * Загружаем новое изображение
     * @param image новое изображение
     * @return название файла
     */
    String addImage(MultipartFile image);

    /**
     * Загружает изображение по названию изображения
     *
     * @param fileName название изображения
     * @return изображение в виде byte[]
     */
    byte[] loadImage(String fileName);

    byte[] loadImageFail(String fileName);

    Picture updateImageFail(MultipartFile image, Picture oldPicture);

    void deleteImageFail(Picture picture);
}
