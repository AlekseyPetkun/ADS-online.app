package pro.sky.adsonlineapp.controllers;

import org.springframework.web.bind.annotation.*;
import pro.sky.adsonlineapp.dto.AdsDto;
import pro.sky.adsonlineapp.dto.CreateAds;
import pro.sky.adsonlineapp.service.AdsService;

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
    public Collection<AdsDto> getAllAds() {

        try {
            return adsService.getAllAds();
        } catch (RuntimeException e) {
            e.getStackTrace();
            return null;
        }
    }

    @PostMapping
    public AdsDto addAd(@RequestBody CreateAds dto) {

        AdsDto adsDto = adsService.addAd(dto);
        return adsDto;
    }

}
