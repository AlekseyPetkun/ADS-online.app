package pro.sky.adsonlineapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import pro.sky.adsonlineapp.model.Comment;

import java.util.List;

@Data
public class ResponseWrapperComment {
    // общее количество комментариев
    @JsonProperty("count")
    private Integer count;

    @JsonProperty("results")
    private List<Comment> comments;
}
