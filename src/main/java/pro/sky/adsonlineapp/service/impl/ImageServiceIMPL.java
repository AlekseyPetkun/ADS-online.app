package pro.sky.adsonlineapp.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pro.sky.adsonlineapp.model.Ad;
import pro.sky.adsonlineapp.repository.ImageRepository;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;
@Service
public class ImageServiceIMPL {
    private final ImageRepository imageRepository;

    public ImageServiceIMPL(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Integer addImage(MultipartFile image) {
        Ad ad = new Ad();
        try {
            byte[] bytes = image.getBytes();
            ad.setImage(bytes);
        } catch (IOException e) {

        }
        ad.setImage(UUID.randomUUID().toString().getBytes());
        Ad savedEntity = imageRepository.saveAndFlush(ad);
        return savedEntity.getId();
    }

    public Optional<Object> image(Integer id) {

        return null;
    }

}
