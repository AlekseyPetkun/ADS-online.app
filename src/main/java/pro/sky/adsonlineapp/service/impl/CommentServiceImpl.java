package pro.sky.adsonlineapp.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import pro.sky.adsonlineapp.constants.Role;
import pro.sky.adsonlineapp.dto.AdsDto;
import pro.sky.adsonlineapp.dto.CommentDto;
import pro.sky.adsonlineapp.dto.CreateComment;
import pro.sky.adsonlineapp.dto.ResponseWrapperComment;
import pro.sky.adsonlineapp.exceptions.NotFoundEntityException;
import pro.sky.adsonlineapp.exceptions.ValidationException;
import pro.sky.adsonlineapp.model.Ad;
import pro.sky.adsonlineapp.model.Comment;
import pro.sky.adsonlineapp.model.User;
import pro.sky.adsonlineapp.repository.AdsRepository;
import pro.sky.adsonlineapp.repository.CommentRepository;
import pro.sky.adsonlineapp.repository.UserRepository;
import pro.sky.adsonlineapp.service.CommentService;
import pro.sky.adsonlineapp.service.ValidationService;
import pro.sky.adsonlineapp.utils.CommentMappingUtils;
import pro.sky.adsonlineapp.utils.CreateCommentMappingUtils;

import java.util.ArrayList;
import java.util.List;

import static pro.sky.adsonlineapp.constants.Message.NOT_FOUND_ENTITY;

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
    private final UserRepository userRepository;

    @Override
    public CommentDto saveComment(Integer id, CreateComment dto, String userDetails) {

        if (!validationService.validate(dto)) {
            throw new ValidationException(dto.toString());
        }
        User user = userRepository.findByUsername(userDetails);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        Ad ad = adsRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityException(NOT_FOUND_ENTITY));

        Comment entity = createComments.mapToEntity(dto, user, ad);
        commentRepository.save(entity);
        return comments.mapToDto(entity);
    }

    @Override
    public CommentDto updateComment(Integer adId, Integer commentId, CommentDto dto, String userDetails) {

//        Ad ad = adsRepository.findById(adId)
//                .orElseThrow(() -> new NotFoundEntityException(NOT_FOUND_ENTITY));
        User authorOrAdmin = userRepository.findByUsername(userDetails);
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NotFoundEntityException(NOT_FOUND_ENTITY));

        if (comment.getAuthor().getUsername().equals(userDetails)
                || authorOrAdmin.getRole().equals(Role.ADMIN)
                /*&& ad.getAuthor().getUsername().equals(userDetails)
                || ad.getAuthor().getRole().equals(Role.ADMIN)*/) {

            comment.setText(dto.getText());
            commentRepository.save(comment);
//            comment = commentRepository.updateCommentById(
//                    dto.getAuthor(),
//                    dto.getAuthorImage(),
//                    dto.getAuthorFirstName(),
//                    dto.getCreatedAt(),
//                    dto.getText(),
//                    commentId);

            CommentDto commentDto = comments.mapToDto(comment);
            return commentDto;
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }

    @Override
//    @Transactional
    public boolean deleteComment(Integer adId, Integer commentId, String userDetails) {

//        Ad ad = adsRepository.findById(adId)
//                .orElseThrow(() -> new NotFoundEntityException(NOT_FOUND_ENTITY));

        User authorOrAdmin = userRepository.findByUsername(userDetails);
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NotFoundEntityException(NOT_FOUND_ENTITY));

        if (comment.getAuthor().getUsername().equals(userDetails)
                || authorOrAdmin.getRole().equals(Role.ADMIN)
                /*&& ad.getAuthor().getUsername().equals(userDetails)
                || ad.getAuthor().getRole().equals(Role.ADMIN)*/) {

            commentRepository.delete(comment);
            return true;
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }

    @Override
    public ResponseWrapperComment getComments(Integer id) {

        List<Comment> commentsEntity = commentRepository.findByAdId(id);
        List<CommentDto> dto = new ArrayList<>();

        for (Comment comment : commentsEntity) {
            dto.add(comments.mapToDto(comment));
        }

        return new ResponseWrapperComment(dto.size(), dto);
    }
}