package pro.sky.adsonlineapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import pro.sky.adsonlineapp.model.Ad;

import java.util.List;

public class ResponseWrapperAds {
    // общее количество объявлений
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("results")
    private List<Ad> comments;
}
