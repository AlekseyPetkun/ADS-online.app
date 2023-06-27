package pro.sky.adsonlineapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pro.sky.adsonlineapp.constants.Role;

/**
 * DTO регистрации.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterReq {

    private String username; // логин
    private String password; // пароль
    private String firstName; // имя пользователя
    private String lastName; // фамилия пользователя
    private String phone; // телефон пользователя
    private Role role; // роль пользователя
}
