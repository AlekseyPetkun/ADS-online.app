package pro.sky.adsonlineapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO объявления.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdsDto {

    private Integer author;
    private String image;
    private Integer id;
    private Integer price;
    private String title;

}
