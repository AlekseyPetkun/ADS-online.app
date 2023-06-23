package pro.sky.adsonlineapp.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.webjars.NotFoundException;
import pro.sky.adsonlineapp.dto.AdsDto;
import pro.sky.adsonlineapp.exceptions.NotFoundEntityException;
import pro.sky.adsonlineapp.model.Ad;
import pro.sky.adsonlineapp.repository.ImageRepository;
import pro.sky.adsonlineapp.service.impl.ImageServiceIMPL;

import java.util.List;
import java.util.stream.Collectors;

import static pro.sky.adsonlineapp.constants.Message.NOT_FOUND_ENTITY;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("/ads")
@Tag(name = "добавление картинки")
public class AddImage {

    private final ImageServiceIMPL imageServiceIMPL;
    private final ImageRepository imageRepository;

    @PostMapping("/upl")
    public ResponseEntity<Integer> saveAds(@RequestParam MultipartFile image) {

        Integer image2 = imageServiceIMPL.addImage(image);
        return ResponseEntity.ok(image2);
    }
    @GetMapping(value = "/images/{id}")
    @ResponseBody
    public ResponseEntity<byte[]> getAd(@PathVariable Integer id) {
        byte[] image = imageRepository.findById(id).orElseThrow().getImage();
        HttpHeaders hed = new HttpHeaders();
        hed.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(image, hed, HttpStatus.OK);

    }
   /* @GetMapping(value = "/images/{id}", produces = {MediaType.IMAGE_PNG_VALUE})
    public ResponseEntity<byte[]> getImage(@PathVariable Integer id) {
        Ad ad = imageRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ad not found"));

        byte[] imageBytes = ad.getImage();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        headers.setContentLength(imageBytes.length);

        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }*/

}
