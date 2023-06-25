package pro.sky.adsonlineapp.utils;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Service;
import pro.sky.adsonlineapp.dto.CommentDto;
import pro.sky.adsonlineapp.model.Comment;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.TimeZone;

/**
 * Бизнес-логика по маппингу комментариев (Comment).
 */
@Service
public class CommentMappingUtils {

    public CommentDto mapToDto(Comment entity) {
        TimeZone tz = TimeZone.getDefault();
        LocalDateTime ldt = LocalDateTime.ofInstant(entity.getCreatedAt(), tz.toZoneId());

        CommentDto dto = new CommentDto();
        dto.setAuthor(entity.getAuthor().getId());
        dto.setAuthorFirstName(entity.getAuthor().getFirstName());
        dto.setPk(entity.getId());
        dto.setAuthorImage(entity.getAuthor().getImage());
        //dto.setCreatedAt(Instant.now().compareTo(entity.getCreatedAt()));
        dto.setCreatedAt(ldt);
        dto.setText(entity.getText());

        return dto;
    }
}
