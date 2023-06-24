package pro.sky.adsonlineapp.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Сервис по работе с картинками.
 */
public interface PictureService {

    String addImage(MultipartFile image);
}
