package pro.sky.adsonlineapp.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pro.sky.adsonlineapp.model.Ad;
import pro.sky.adsonlineapp.model.Picture;
import pro.sky.adsonlineapp.repository.PictureRepository;
import pro.sky.adsonlineapp.service.PictureService;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;
@Service
@AllArgsConstructor
public class PictureServiceImpl implements PictureService {
    private final PictureRepository imageRepository;

    @Override
    public String addImage(MultipartFile image) {

        Picture picture = new Picture();
        try {
            byte[] bytes = image.getBytes();
            picture.setData(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        picture.setId(UUID.randomUUID().toString());
        Picture savedEntity = imageRepository.saveAndFlush(picture);
        return savedEntity.getId();
    }

    public Optional<Object> image(Integer id) {

        return null;
    }

}
