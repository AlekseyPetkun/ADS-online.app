package pro.sky.adsonlineapp.utils.impl;

import org.springframework.stereotype.Service;
import pro.sky.adsonlineapp.dto.CommentDto;
import pro.sky.adsonlineapp.model.Comment;
import pro.sky.adsonlineapp.utils.MappingUtils;
/**
 * Бизнес-логика по маппингу комментариев (Comment).
 */
@Service
public class CommentMappingUtils {

    public CommentDto mapToDto(Comment entity) {
        CommentDto dto = new CommentDto();
        dto.setAuthor(entity.getAuthor().getId());
        dto.setPk(entity.getCommentId());
        dto.setText(entity.getText());
        return dto;
    }

    public Comment mapToEntity(CommentDto dto) {
        Comment entity = new Comment();
        entity.setCommentId(dto.getPk());
        entity.setText(dto.getText());
        return entity;
    }
}
