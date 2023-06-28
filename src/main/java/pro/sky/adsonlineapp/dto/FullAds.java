package pro.sky.adsonlineapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO информации об объявлении.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullAds{

    private Integer pk; // id объявления
    private String authorFirstName; // имя автора объявления
    private String authorLastName; // фамилия автора объявления
    private String description; // описание объявления
    private String email; // логин автора объявления
    private String image; // ссылка на картинку объявления
    private String phone; // телефон автора объявления
    private Integer price; // цена объявления
    private String title; // заголовок объявления
}
