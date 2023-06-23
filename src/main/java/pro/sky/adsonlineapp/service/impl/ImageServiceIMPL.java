package pro.sky.adsonlineapp.service.impl;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import pro.sky.adsonlineapp.exceptions.NotFoundEntityException;
import pro.sky.adsonlineapp.model.Ad;
import pro.sky.adsonlineapp.repository.ImageRepository;

import java.io.IOException;

import static pro.sky.adsonlineapp.constants.Message.NOT_FOUND_ENTITY;

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
        Ad savedEntity = imageRepository.saveAndFlush(ad);
        return savedEntity.getId();
    }

    public byte[] image(Integer id) {
        byte[] image = imageRepository.findById(id).orElseThrow().getImage();

            HttpHeaders hed = new HttpHeaders();
            hed.setContentType(MediaType.IMAGE_PNG);
            return image;


    }

}
