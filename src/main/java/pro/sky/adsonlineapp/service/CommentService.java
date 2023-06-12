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

     Comment saveComment(Integer id, CreateComment dto);
     boolean deleteComment(Integer adId, Integer commentId);
     CommentDto updateComment(Integer adId, Integer commentId);
     CommentDto getComments(Integer id);

}
