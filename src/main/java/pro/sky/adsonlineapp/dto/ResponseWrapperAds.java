package pro.sky.adsonlineapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import pro.sky.adsonlineapp.model.Ad;

import java.util.List;
@Data
public class ResponseWrapperAds {
    // общее количество объявлений
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("results")
    private List<Ad> comments;
}
