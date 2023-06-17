package pro.sky.adsonlineapp.dto;

import lombok.Data;

/**
 * DTO авторизации.
 */
@Data
public class LoginReqDto {

    private String password;
    private String username;

}
