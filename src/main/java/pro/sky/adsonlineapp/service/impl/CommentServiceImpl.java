package pro.sky.adsonlineapp.service.impl;

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

@Service
public class CommentServiceImpl implements CommentService {
    private final ValidationService validationService;
    private final CommentRepository commentRepository;
    private final AdsRepository adsRepository;
    private final MappingUtils<CreateComment, Comment> createComments;
    private final MappingUtils<CommentDto, Comment> comments;

    public CommentServiceImpl(ValidationService validationService, CommentRepository commentRepository, AdsRepository adsRepository, MappingUtils<CreateComment, Comment> createComments, MappingUtils<CommentDto, Comment> comments) {
        this.validationService = validationService;
        this.commentRepository = commentRepository;
        this.adsRepository = adsRepository;
        this.createComments = createComments;
        this.comments = comments;
    }


    @Override
    public Comment saveComment(Integer id, CreateComment dto) {
        if (!validationService.validate(dto)) {
            throw new ValidationException(dto.toString());
        }
        Comment entity = createComments.mapToEntity(dto);
        commentRepository.save(entity);
        Comment entityOne = commentRepository.findById(entity.getCommentId().intValue())
                .orElseThrow(() -> new NotFoundEntityException("Сущность не найдена!"));
        return entityOne;
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
        }else {
            comment = commentRepository.updateCommentById(adId, commentId);
            CommentDto commentDto = comments.mapToDto(comment);
            return commentDto;
        }
    }
@Override
    public CommentDto getComments(Integer id){

    Comment comment = commentRepository.findById(id)
            .orElseThrow(() -> new NotFoundEntityException("Сущность не найдена!"));
        if (comment == null) {
            throw new NotFoundEntityException("такого комментария нет");
        }
        CommentDto commentDto = comments.mapToDto(comment);
        return commentDto;
    }
}