package pro.sky.adsonlineapp.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.adsonlineapp.dto.CommentDto;
import pro.sky.adsonlineapp.dto.CreateComment;
import pro.sky.adsonlineapp.dto.ResponseWrapperComment;
import pro.sky.adsonlineapp.model.Comment;

/**
 * контроллер для работы с комментариями
 */
@RestController
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("/ads")
public class CommentController {

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
    public ResponseEntity<Comment> addComment(@PathVariable("id") Integer id,
                                         @RequestBody CreateComment comments) {
            Comment comment = new Comment();
        return ResponseEntity.ok(comment);
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
    public ResponseEntity<ResponseWrapperComment> getComments(@PathVariable("id") int id) {
        //Создание нового объекта ResponseWrapperComment,
        //который будет заполнен данными о комментариях и
        //возвращен в качестве ответа на запрос.
        ResponseWrapperComment response = new ResponseWrapperComment();

        return ResponseEntity.ok(response);
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
            description = "отстутсвуют права доступа"
    )
    public ResponseEntity<Object> deleteComment(@PathVariable Integer adId,
                                                 @PathVariable Integer commentId) {

        return ResponseEntity.ok().build();
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
            description = "отстутсвуют права доступа"
    )
    public ResponseEntity<CommentDto> updateComment(@PathVariable Integer adId,
                                                  @PathVariable Integer commentId,
                                                  @RequestBody CommentDto commentDto) {

        return ResponseEntity.ok().build();
    }
    }