package pro.sky.adsonlineapp.service;

import org.springframework.web.multipart.MultipartFile;
import pro.sky.adsonlineapp.model.Picture;

/**
 * Сервис по работе с картинками.
 */
public interface PictureService {

    String addImage(MultipartFile image);

    byte[] loadImageFail(String fileName);
    Picture updateImageFail(MultipartFile image, Picture oldPicture);

    void deleteImageFail(Picture picture);
}
