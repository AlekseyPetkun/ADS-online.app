package pro.sky.adsonlineapp.utils;

import org.springframework.stereotype.Service;
import pro.sky.adsonlineapp.dto.CreateComment;
import pro.sky.adsonlineapp.model.Ad;
import pro.sky.adsonlineapp.model.Comment;
import pro.sky.adsonlineapp.model.User;
import pro.sky.adsonlineapp.utils.MappingUtils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Бизнес-логика по маппингу создание комментариев (CreateComment).
 */
@Service
public class CreateCommentMappingUtils {

    public Comment mapToEntity(CreateComment dto, User author, Ad ad) {

        Comment entity = new Comment();
        entity.setText(dto.getText());
        entity.setAd(ad);
        entity.setAuthor(author);
        entity.setCreatedAt(Instant.now());

        return entity;
    }
}