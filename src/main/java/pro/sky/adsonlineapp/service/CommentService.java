package pro.sky.adsonlineapp.service;

import pro.sky.adsonlineapp.dto.ResponseWrapperComment;
import pro.sky.adsonlineapp.model.Comment;
import pro.sky.adsonlineapp.model.User;

import java.util.Collection;

/**
 * Сервис по работе с комментариями
 */
public interface CommentService {

     ResponseWrapperComment saveComment(ResponseWrapperComment dto);

}
