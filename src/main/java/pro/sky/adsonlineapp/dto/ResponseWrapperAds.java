package pro.sky.adsonlineapp.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * DTO всех объявлений.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseWrapperAds {

    private Integer count; // общее количество объявлений
    private List<AdsDto> results; // все найденные объявления
}
