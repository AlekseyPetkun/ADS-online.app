package pro.sky.adsonlineapp.dto;

import lombok.Data;

@Data
public class ResponseWrapper {
    // общее количество объявлений
    private Integer count;
    // данные о комментарии
    private AdsDto results;
}
