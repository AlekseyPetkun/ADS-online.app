package pro.sky.adsonlineapp.service;

import pro.sky.adsonlineapp.dto.RegisterReq;
import pro.sky.adsonlineapp.constants.Role;

/**
 * Сервис по работе с аутентификацией.
 */
public interface AuthService {

    /**
     * Авторизация пользователя
     *
     * @param userName имя пользователя
     * @param password пароль пользователя
     * @return true or false
     */
    boolean login(String userName, String password);

    /**
     * Регистрация пользователя
     *
     * @param registerReq тело регистрации в виде DTO
     * @param role        роль пользователя
     * @return true or false
     */
    boolean register(RegisterReq registerReq, Role role);
}
