package pro.sky.adsonlineapp.dto;

import lombok.Data;

@Data
public class ResponseWrapperComment {
    //общее количество комментариев
    private Integer count;
    // данные о комментарии
    private CommentDto results;
}
