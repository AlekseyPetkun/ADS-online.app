package pro.sky.adsonlineapp.dto;

import lombok.Data;

/**
 * DTO авторизации.
 */
@Data
public class LoginReq {

    private String password;
    private String username;

}
