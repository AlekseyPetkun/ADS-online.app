package pro.sky.adsonlineapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO создания объявления.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAds {

    private String description; // описание объявления
    private int price; // цена объявления
    private String title; // заголовок объявления
}
