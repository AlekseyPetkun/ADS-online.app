package pro.sky.adsonlineapp.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pro.sky.adsonlineapp.dto.AdsDto;
import pro.sky.adsonlineapp.dto.CreateAds;
import pro.sky.adsonlineapp.dto.FullAds;
import pro.sky.adsonlineapp.dto.ResponseWrapperAds;
import pro.sky.adsonlineapp.model.Ad;
import pro.sky.adsonlineapp.service.AdsService;
import pro.sky.adsonlineapp.service.PictureService;

import java.io.IOException;
import java.security.Principal;

/**
 * Контроллер по работе с объявлениями
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("/ads")
@Tag(name = "API по работе с объявлениями",
        description = "CRUD-операции для работы с объявлениями")

public class AdsController {

    private final AdsService adsService;
    //    private final UserDetails userDetails;
//    private final Principal principal;
//    private final UserService userService;
    private final PictureService pictureService;


    @GetMapping
    @Operation(
            summary = "Получить все объявления",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponseWrapperAds.class)
                            )
                    )
            },
            tags = "Объявления"
    )
    public ResponseEntity<ResponseWrapperAds> getAllAds() {

        try {
            ResponseWrapperAds ads = adsService.getAllAds();
            return ResponseEntity.ok(ads);

        } catch (RuntimeException e) {
            e.getStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @Operation(
            summary = "Добавить объявление",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Created",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = AdsDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized"
                    )
            },
            tags = "Объявления"
    )

    public ResponseEntity<AdsDto> addAd(@RequestPart CreateAds properties,
                                        @RequestPart(name = "image") MultipartFile image,
                                        Principal principal) {


        try {
            AdsDto adsDto = adsService.addAd(properties, image, principal.getName());
            return ResponseEntity.ok(adsDto);

        } catch (RuntimeException e) {
            e.getStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Получить информацию об объявлении",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = FullAds.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized"
                    )
            },
            tags = "Объявления"
    )
    public ResponseEntity<FullAds> getAds(@PathVariable Integer id) {

        try {
            FullAds dto = adsService.getFullAdsById(id);
            return ResponseEntity.ok().body(dto);

        } catch (RuntimeException e) {
            e.getStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Удалить объявление",
            responses = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "No Content"
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized"
                    ),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden"
                    )
            },
            tags = "Объявления"
    )

    public ResponseEntity<?> removeAd(@PathVariable Integer id,
                                      Principal principal) {

        try {
            return ResponseEntity.ok().body(adsService.deleteAdById(id, principal.getName()));

        } catch (RuntimeException e) {
            e.getStackTrace();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @PatchMapping("/{id}")
    @Operation(
            summary = "Обновить информацию об объявлении",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = AdsDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized"
                    ),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden"
                    )
            },
            tags = "Объявления"
    )

    public ResponseEntity<AdsDto> updateAds(@PathVariable Integer id,
                                            @RequestBody CreateAds ads,
                                            Principal principal) {

        try {
            AdsDto adsDto = adsService.updateAdsById(id, ads, principal.getName());
            return ResponseEntity.ok(adsDto);

        } catch (RuntimeException e) {
            e.getStackTrace();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @GetMapping("/me")
    @Operation(
            summary = "Получить объявления авторизованного пользователя",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponseWrapperAds.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized"
                    )
            },
            tags = "Объявления"
    )

    public ResponseEntity<ResponseWrapperAds> getAdsMe(Principal principal) {


        try {
            ResponseWrapperAds dto = adsService.getAdsMe(principal.getName());
            return ResponseEntity.ok(dto);

        } catch (RuntimeException e) {
            e.getStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PatchMapping(value = "/{id}/image", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @Operation(
            summary = "Обновить картинку объявления",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_OCTET_STREAM_VALUE,
                                    schema = @Schema(implementation = String[].class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized"
                    ),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden"
                    )
            },
            tags = "Объявления"
    )

    public ResponseEntity<?> updateAdImage(@PathVariable Integer id,
                                           @RequestPart MultipartFile image) {

//        var username = System.getProperty("user");
//        if (username == null)
//            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        //var user = userService.getUser(username);
        try {
            return ResponseEntity.ok().body(adsService.updateAdImage(id, image));
        } catch (RuntimeException e) {
            e.getStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/found_ads")
    @Operation(
            summary = "Поиск объявлений по названию",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponseWrapperAds.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized"
                    )
            },
            tags = "Объявления"
    )
    public ResponseEntity<ResponseWrapperAds> findByDescriptionAd(@RequestParam String description) {

        try {
            ResponseWrapperAds dto = adsService.findByDescriptionAd(description);
            return ResponseEntity.ok().body(dto);

        } catch (RuntimeException e) {
            e.getStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    //  @GetMapping(value = "image/{id}", produces = {MediaType.IMAGE_PNG_VALUE})
    //public ResponseEntity<byte[]> getImage(@PathVariable String id) {

    //      try {
    //         byte[] imageBytes = adsService.getImageById(id);
    //         return ResponseEntity.ok(imageBytes);

    //       } catch (RuntimeException e) {
    //          e.getStackTrace();
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    //      }
    //   }
    @Operation(
            summary = "Получить картинку объявления",
            tags = "Объявления",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "404", description = "Not found", content = @Content())
            })
    @GetMapping(value = "/image/{id}", produces = {
            MediaType.IMAGE_PNG_VALUE,
            MediaType.IMAGE_JPEG_VALUE,
            MediaType.APPLICATION_OCTET_STREAM_VALUE
    })
    public ResponseEntity<byte[]> getImage(@PathVariable("id") String id) {
        return ResponseEntity.ok(pictureService.loadImageFail(id));
    }

}