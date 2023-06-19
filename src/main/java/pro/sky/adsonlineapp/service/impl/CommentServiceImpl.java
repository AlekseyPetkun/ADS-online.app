package pro.sky.adsonlineapp.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pro.sky.adsonlineapp.dto.CommentDto;
import pro.sky.adsonlineapp.dto.CreateComment;
import pro.sky.adsonlineapp.exceptions.NotFoundEntityException;
import pro.sky.adsonlineapp.exceptions.ValidationException;
import pro.sky.adsonlineapp.model.Ad;
import pro.sky.adsonlineapp.model.Comment;
import pro.sky.adsonlineapp.repository.AdsRepository;
import pro.sky.adsonlineapp.repository.CommentRepository;
import pro.sky.adsonlineapp.service.CommentService;
import pro.sky.adsonlineapp.service.ValidationService;
import pro.sky.adsonlineapp.utils.MappingUtils;
import pro.sky.adsonlineapp.utils.impl.CommentMappingUtils;
import pro.sky.adsonlineapp.utils.impl.CreateCommentMappingUtils;

/**
 * Бизнес-логика по работе с комментариями.
 */
@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final ValidationService validationService;
    private final CommentRepository commentRepository;
    private final AdsRepository adsRepository;
    private final CreateCommentMappingUtils createComments;
    private final CommentMappingUtils comments;

    @Override
    public Comment saveComment(Integer id, CreateComment dto) {
        if (!validationService.validate(dto)) {
            throw new ValidationException(dto.toString());
        }
        Comment entity = createComments.mapToEntity(dto);
        return commentRepository.save(entity);
    }

    @Override
    public boolean deleteComment(Integer adId, Integer commentId) {
        Ad ad = adsRepository.findById(adId).orElse(null);
        Comment comment = commentRepository.findById(commentId).orElse(null);
        if (ad == null) {
            return false;
        } else if (comment == null || !comment.getAd().equals(ad)) {
            return false;
        } else {
            commentRepository.delete(comment);
            return true;
        }
    }

    @Override
    @Transactional
    public CommentDto updateComment(Integer adId, Integer commentId) {
        Ad ad = adsRepository.findById(adId).orElse(null);
        Comment comment = commentRepository.findById(commentId).orElse(null);
        if (ad == null) {
            throw new NotFoundEntityException("отсутствует такое объявление");
        } else if (comment == null || !comment.getAd().equals(ad)) {
            throw new NotFoundEntityException("отсутствует такой комментарий");
        } else {
            comment = commentRepository.updateCommentById(adId, commentId);
            CommentDto commentDto = comments.mapToDto(comment);
            return commentDto;
        }
    }

    @Override
    public CommentDto getComments(Integer id) {

        Comment comment = commentRepository.getReferenceById(id);
        if (comment == null) {
            throw new NotFoundEntityException("такого комментария нет");
        }
        CommentDto commentDto = comments.mapToDto(comment);
        return commentDto;
    }
}