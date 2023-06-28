package pro.sky.adsonlineapp.service;

import pro.sky.adsonlineapp.dto.CommentDto;
import pro.sky.adsonlineapp.dto.CreateComment;
import pro.sky.adsonlineapp.dto.ResponseWrapperComment;
import pro.sky.adsonlineapp.model.Comment;
import pro.sky.adsonlineapp.model.User;

import java.util.Collection;

/**
 * Сервис по работе с комментариями
 */
public interface CommentService {

    /**
     * Создание комментария
     *
     * @param id          идентификатор комментария
     * @param dto         тело создаваемого комментария в виде DTO
     * @param userDetails информация о пользователе
     * @return созданный комментарий
     */
    CommentDto saveComment(Integer id, CreateComment dto, String userDetails);

    /**
     * Удалить комментарий
     *
     * @param adId        идентификатор объявления удаляемого комментария
     * @param commentId   идентификатор удаляемого комментария
     * @param userDetails информация о пользователе
     * @return true or false
     */
    boolean deleteComment(Integer adId, Integer commentId, String userDetails);

    /**
     * Изменить комментарий
     *
     * @param adId        идентификатор объявления изменяемого комментария
     * @param commentId   идентификатор изменяемого комментария
     * @param dto         тело измененного комментария
     * @param userDetails информация о пользователе
     * @return измененный комментарий
     */
    CommentDto updateComment(Integer adId, Integer commentId, CommentDto dto, String userDetails);

    /**
     * Получить комментарий
     *
     * @param id идентификатор комментария
     * @return комментарий
     */
    ResponseWrapperComment getComments(Integer id);
}

