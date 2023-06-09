package pro.sky.adsonlineapp.utils.impl;

import org.springframework.stereotype.Service;
import pro.sky.adsonlineapp.dto.ResponseWrapperComment;
import pro.sky.adsonlineapp.model.Comment;
import pro.sky.adsonlineapp.utils.MappingUtils;

import java.util.ArrayList;
import java.util.List;

@Service
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
        return null;
    }
}

