package pro.sky.adsonlineapp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.adsonlineapp.dto.AdsDto;
import pro.sky.adsonlineapp.service.AdsService;

import java.util.Collection;

/**
 * Контроллер объявлений.
 */
@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/ads")
public class AdsController {

    private final AdsService adsService;

    public AdsController(AdsService adsService) {
        this.adsService = adsService;
    }

    @GetMapping
    public ResponseEntity<Collection<AdsDto>> getAllAds() {

        try {
            return ResponseEntity.ok(adsService.getAllAds());
        } catch (RuntimeException e) {
            e.getStackTrace();
            return ResponseEntity.notFound().build();
        }
    }


}
