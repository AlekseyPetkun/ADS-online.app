package pro.sky.adsonlineapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pro.sky.adsonlineapp.model.Comment;

import java.util.List;

/**
 * DTO всех комментариев.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseWrapperComment {

    private Integer count; // общее количество комментариев
    private List<CommentDto> results; // все комментарии
}
