package pro.sky.adsonlineapp.controllers;

import io.swagger.v3.oas.annotations.Operation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;
import pro.sky.adsonlineapp.dto.UserDto;
import pro.sky.adsonlineapp.model.User;
import pro.sky.adsonlineapp.service.UserService;
import pro.sky.adsonlineapp.dto.NewPassword;


import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.MediaType;
;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

/**
 * Контроллер для работы с пользователями
 */
@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    @Operation(
            summary = "Обновление пароля",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Пароль изменен"
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized"
                    ),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not Found"
                    )
            },
            tags = "Пользователи"
    )
    @PostMapping("/set_password")
    public ResponseEntity<?> setPassword(@RequestBody NewPassword password,
                                         Principal principal) {

        if (userService.setPassword(password, principal.getName())) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @Operation(
            summary = "Получить информацию об авторизованном пользователе",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Информация получена",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = User.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized"
                    ),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not Found"
                    )
            },
            tags = "Пользователи"
    )
    @GetMapping("/me")
    public ResponseEntity<UserDto> getUser(Principal principal) {

        UserDto user = userService.getUser(principal.getName());
        if (user != null) {
            user.setImage("stupid face2.png");
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @Operation(
            summary = "Обновить информацию об авторизованном пользователе",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Пользователь изменен",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = User.class)
                            )
                    ),
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
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not Found"
                    )
            },
            tags = "Пользователи"
    )
    @PatchMapping("/me")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto dto,
                                              Principal principal) {

        try {
            UserDto userDto = userService.updateUser(dto, principal.getName());
            return ResponseEntity.ok(userDto);
        } catch (RuntimeException e) {
            e.getStackTrace();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @Operation(
            summary = "Обновить аватар авторизованного пользователя",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Фото изменено"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not Found"
                    )
            },
            tags = "Пользователи"
    )
    @PatchMapping(value = "/me/image", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> updateUserImage(@RequestPart(name = "image") MultipartFile image) {
        var username = System.getProperty("user");
        if (username == null)
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        //var user = userService.getUser(username);
        if (userService.updateUserImage(username, image)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
