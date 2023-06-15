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
    // общее количество объявлений
    @JsonProperty("count")
    private Integer count;

    @JsonProperty("results")
    private List<AdsDto> ads;
}
