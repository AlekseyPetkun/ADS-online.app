package pro.sky.adsonlineapp.dto;

import lombok.Data;

/**
 * DTO пользователей.
 */
@Data
public class UserDto {

    private Integer id; // id пользователя
    private String userName; // логин пользователя
    private String firstName;// имя пользователя
    private String lastName;// фамилия пользователя
    private String phone; // телефон пользователя
    private String picture;// ссылка на аватар пользователя
}
