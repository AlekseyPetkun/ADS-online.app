package pro.sky.adsonlineapp.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pro.sky.adsonlineapp.dto.CommentDto;
import pro.sky.adsonlineapp.dto.CreateComment;
import pro.sky.adsonlineapp.model.Comment;
import pro.sky.adsonlineapp.service.CommentService;

/**
 * контроллер для работы с комментариями
 */
@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/ads")
public class CommentController {


    @Autowired
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
    @PreAuthorize("hasRole('USER') OR hasRole('ADMIN')")
    public ResponseEntity<Comment> addComment(@PathVariable("id") Integer id,
                                         @RequestBody CreateComment comments) {
        Comment comment = commentService.saveComment(id, comments);
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
    @PreAuthorize("hasRole('USER') OR hasRole('ADMIN')")
    public ResponseEntity<CommentDto> getComments(@PathVariable("id") Integer id) {
        CommentDto commentDto = commentService.getComments(id);
        return ResponseEntity.ok(commentDto);
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
    @PreAuthorize("hasRole('USER') OR hasRole('ADMIN')")
    public ResponseEntity<Object> deleteComment(@PathVariable Integer adId,
                                                 @PathVariable Integer commentId) {
        return ResponseEntity.ok().body(commentService.deleteComment(adId, commentId));
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
    @PreAuthorize("hasRole('USER') OR hasRole('ADMIN')")
    public ResponseEntity<CommentDto> updateComment(@PathVariable Integer adId,
                                                  @PathVariable Integer commentId,
                                                  @RequestBody Comment comment) {
        CommentDto commentDto1 = commentService.updateComment(adId, commentId);
        return ResponseEntity.ok().body(commentDto1);
    }
    }