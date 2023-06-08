package pro.sky.adsonlineapp.utils.impl;

import pro.sky.adsonlineapp.dto.ResponseWrapperComment;
import pro.sky.adsonlineapp.model.Comment;
import pro.sky.adsonlineapp.utils.MappingUtils;

import java.util.ArrayList;
import java.util.List;

public class CommentMappingUtilsImpl implements MappingUtils<ResponseWrapperComment, Comment> {

    @Override
    public ResponseWrapperComment mapToDto(Comment entity) {
        ResponseWrapperComment dto = new ResponseWrapperComment();
        List<Comment> comments = new ArrayList<>();
        comments.add(entity);
        dto.setComments(comments);
        return dto;
    }

    @Override
    public Comment mapToEntity(ResponseWrapperComment dto) {
        Comment comment = new Comment();
        List<Comment> comments = dto.getComments();
        if (comments != null && !comments.isEmpty()) {
            comment = comments.get(0);
        }
        return comment;
    }
    }

