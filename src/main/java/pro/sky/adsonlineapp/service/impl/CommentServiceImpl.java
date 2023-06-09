package pro.sky.adsonlineapp.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.adsonlineapp.dto.ResponseWrapperComment;
import pro.sky.adsonlineapp.exceptions.ValidationException;
import pro.sky.adsonlineapp.model.Comment;
import pro.sky.adsonlineapp.repository.CommentRepository;
import pro.sky.adsonlineapp.service.CommentService;
import pro.sky.adsonlineapp.service.ValidationService;
import pro.sky.adsonlineapp.utils.MappingUtils;

@Service
public class CommentServiceImpl implements CommentService {
    private final ValidationService validationService;
    private final CommentRepository commentRepository;
    private final MappingUtils<ResponseWrapperComment, Comment> createComments;

    public CommentServiceImpl(ValidationService validationService, CommentRepository commentRepository, MappingUtils<ResponseWrapperComment, Comment> createComments) {
        this.validationService = validationService;
        this.commentRepository = commentRepository;
        this.createComments = createComments;
    }

    @Override
    public ResponseWrapperComment saveComment(ResponseWrapperComment dto) {
        if (!validationService.validate(dto)) {
            throw new ValidationException(dto.toString());
        }
        Comment entity = createComments.mapToEntity(dto);
        commentRepository.save(entity);
        Comment entityOne = commentRepository.getReferenceById(entity.getCommentId().intValue());
        ResponseWrapperComment responseWrapperComment = createComments.mapToDto(entityOne);
        return responseWrapperComment;
    }
}
