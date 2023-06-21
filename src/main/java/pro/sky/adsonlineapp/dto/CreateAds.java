package pro.sky.adsonlineapp.dto;

import lombok.Data;

/**
 * DTO создания объявления.
 */
@Data
public class CreateAds {
    private String description; // описание объявления
    private int price; // цена объявления
    private String title; // заголовок объявления
}
