package pro.sky.adsonlineapp.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pro.sky.adsonlineapp.dto.CommentDto;
import pro.sky.adsonlineapp.dto.CreateComment;
import pro.sky.adsonlineapp.dto.ResponseWrapperComment;
import pro.sky.adsonlineapp.dto.UserDto;
import pro.sky.adsonlineapp.model.Comment;
import pro.sky.adsonlineapp.service.CommentService;
import pro.sky.adsonlineapp.service.PictureService;

import java.security.Principal;

/**
 * контроллер для работы с комментариями
 */
@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/ads")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{id}/comments")
    @Operation(
            summary = "Добавить комментарий к объявлению",
            description = "Нужно написать комментарий "
    )
    @ApiResponse(
            responseCode = "200",
            description = "Комментарий добавлен"
    )
    @ApiResponse(
            responseCode = "401",
            description = "для того чтобы оставить комментарий необходимо авторизоваться"
    )
    public ResponseEntity<CommentDto> addComment(@PathVariable("id") Integer id,
                                                 @RequestBody CreateComment comments,
                                                 Principal principal) {

        try {
            CommentDto comment = commentService.saveComment(id, comments, principal.getName());
            return ResponseEntity.ok(comment);
        } catch (RuntimeException e) {
            e.getStackTrace();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @GetMapping("/{id}/comments")
    @Operation(
            summary = "Получить комментарии объявления",
            description = "Нужно написать id автора "
    )
    @ApiResponse(
            responseCode = "200",
            description = "Комментарий найден"
    )
    @ApiResponse(
            responseCode = "401",
            description = "для того чтобы найти комментарий необходимо авторизоваться"
    )
    public ResponseEntity<ResponseWrapperComment> getComments(@PathVariable("id") Integer id) {

        try {
            ResponseWrapperComment commentDto = commentService.getComments(id);
            return ResponseEntity.ok(commentDto);
        } catch (RuntimeException e) {
            e.getStackTrace();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @DeleteMapping("/{adId}/comments/{commentId}")
    @Operation(
            summary = "Удаление комментарий",
            description = "нужно написать комментарий id и рекламу id"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Удалось удалить комментарий"
    )
    @ApiResponse(
            responseCode = "401",
            description = "чтобы удалить комментарий необходимо авторизоваться"
    )
    @ApiResponse(
            responseCode = "403",
            description = "отсутствуют права доступа"
    )
    public ResponseEntity<?> deleteComment(@PathVariable Integer adId,
                                           @PathVariable Integer commentId,
                                           Principal principal) {
        try {
            return ResponseEntity.ok(commentService.deleteComment(adId, commentId, principal.getName()));
        } catch (RuntimeException e) {
            e.getStackTrace();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @PatchMapping("{adId}/comments/{commentId}")
    @Operation(
            summary = "обновление комментария",
            description = "нужно написать комментарий id и рекламу id"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Удалось обновить комментарий"
    )
    @ApiResponse(
            responseCode = "401",
            description = "чтобы обновить комментарий необходимо авторизоваться"
    )
    @ApiResponse(
            responseCode = "403",
            description = "отсутствуют права доступа"
    )
    public ResponseEntity<CommentDto> updateComment(@PathVariable Integer adId,
                                                    @PathVariable Integer commentId,
                                                    @RequestBody CommentDto comment,
                                                    Principal principal) {

        try {
            CommentDto commentDto = commentService.updateComment(adId, commentId, comment, principal.getName());
            return ResponseEntity.ok(commentDto);
        } catch (RuntimeException e) {
            e.getStackTrace();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
}