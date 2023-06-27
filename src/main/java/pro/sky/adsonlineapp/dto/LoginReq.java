package pro.sky.adsonlineapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO авторизации.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginReq {

    private String password; // пароль
    private String username; // логин

}
