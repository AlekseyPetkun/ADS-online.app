package pro.sky.adsonlineapp.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pro.sky.adsonlineapp.dto.AdsDto;
import pro.sky.adsonlineapp.dto.CreateAds;
import pro.sky.adsonlineapp.dto.FullAds;
import pro.sky.adsonlineapp.dto.ResponseWrapperAds;
import pro.sky.adsonlineapp.model.Picture;
import pro.sky.adsonlineapp.service.AdsService;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Контроллер объявлений.
 */
@RestController
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("/ads")
public class AdsController {

    private final AdsService adsService;

    public AdsController(AdsService adsService) {
        this.adsService = adsService;
    }

    @GetMapping
    public Collection<ResponseWrapperAds> getAllAds() {

        return new ArrayList<>();
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public AdsDto addAd(@RequestPart CreateAds dto,
                        @RequestPart(name = "image") MultipartFile image) {

        AdsDto adsDto = adsService.addAd(dto);
        return adsDto;
    }

    @GetMapping("/{id}")
    public FullAds getFullAdsById(@PathVariable Integer id) {

        return new FullAds();
    }

    @DeleteMapping("/{id}")
    public boolean deleteAdById(@PathVariable Integer id) {
        return false;
    }

    @PatchMapping("/{id}")
    public AdsDto updateAdById(@PathVariable Integer id,
                               @RequestBody CreateAds dto) {

        return new AdsDto();
    }

    @GetMapping("/me")
    public ResponseWrapperAds getFullAdsMe() {

        return new ResponseWrapperAds();
    }

    @PatchMapping(value = "/{id}/image", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})

    public Picture updateImageById(@PathVariable Integer id,
                                   @RequestPart MultipartFile image) {

        return new Picture();
    }

}
