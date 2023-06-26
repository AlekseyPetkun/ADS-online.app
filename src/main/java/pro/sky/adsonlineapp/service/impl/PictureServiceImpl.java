package pro.sky.adsonlineapp.service.impl;
import org.springframework.beans.factory.annotation.Value;
import pro.sky.adsonlineapp.model.Picture;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pro.sky.adsonlineapp.model.Ad;
import pro.sky.adsonlineapp.model.Picture;
import pro.sky.adsonlineapp.repository.ImageRepository;
import pro.sky.adsonlineapp.repository.PictureRepository;
import pro.sky.adsonlineapp.service.PictureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.UUID;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.URL;
import java.lang.String;
import static java.nio.file.Files.*;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class PictureServiceImpl implements PictureService {
//    private final PictureRepository imageRepository;

 //   @Override
//    public String addImage(MultipartFile image) {

 //       Picture picture = new Picture();
 //       try {
//            byte[] bytes = image.getBytes();
 //           picture.setData(bytes);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
// }
 //       picture.setId(UUID.randomUUID().toString());
//        Picture savedEntity = imageRepository.saveAndFlush(picture);
 //       return savedEntity.getId();
 //   }

 //   public Optional<Object> image(Integer id) {

 //       return null;
//    }
    private final String desktopPath = System.getProperty("user.dir") + File.separator + "images";
    //@Value("${default.image.url}")
    //private String url;


    @Override
    public String addImage(MultipartFile image) {
        Picture picture = new Picture();
        try {
            String fileName = UUID.randomUUID() + type(image);
            picture.setId(fileName);
            createDirectories(Paths.get(desktopPath));
            image.transferTo(new File(desktopPath + File.separator + fileName));
            log.info("Image file created by  name: {}", fileName);
        } catch (IOException e) {
            log.error("Error while saving image file{}", picture.getId());
        }
        return picture.getId();
    }

    @Override
    public byte[] loadImage(String fileName) {
        File image;
        byte[] outputFileBytes = null;
        try {
            image = new File(desktopPath, fileName);
            if (exists(image.toPath())) {
                outputFileBytes = readAllBytes(image.toPath());
                log.info("loadImage: File loaded successfully");
            } else {
                try (InputStream in = new URL("").openStream()) {
                    outputFileBytes = in.readAllBytes();
                    log.info("loadImage: File loaded default successfully");
                }
            }
        } catch (IOException e) {
            log.error("file load error");
        }
        return outputFileBytes;
    }

    @Override
    public byte[] loadImageFail(String fileName) {
        File image;
        byte[] outputFileBytes = null;
        try {
            image = new File(desktopPath, fileName);
            outputFileBytes = readAllBytes(image.toPath());
            log.info("loadImageFail: File loaded successfully");
        } catch (IOException e) {
            log.error("loadImageFail: Error while loading file {}", fileName);

        }
        return outputFileBytes;
    }


    private String type(MultipartFile image) {
        String type = image.getContentType();
        assert type != null;
        type = type.replace("image/", ".");
        return type;
    }


    @Override
    public Picture updateImageFail(MultipartFile image, Picture oldPicture) {
        Picture newImage = new Picture();
        try {
            String fileName = UUID.randomUUID() + type(image);
            createDirectories(Paths.get(desktopPath));
            deleteImageFail(oldPicture);
            image.transferTo(new File(desktopPath + File.separator + fileName));
            newImage.setId(fileName);
            log.info("File updated successfully");
        } catch (IOException e) {
            log.error("Error while updating file {}", oldPicture.getId());
        }
        return newImage;
    }

    @Override
    public void deleteImageFail(Picture picture) {

        Path path = Paths.get(desktopPath + File.separator + picture.getId());
        try {
            deleteIfExists(path);
            log.info("File deleted successfully");
        } catch (IOException e) {
            log.error("Error while deleting file {}", picture.getId());
        }
    }
}

