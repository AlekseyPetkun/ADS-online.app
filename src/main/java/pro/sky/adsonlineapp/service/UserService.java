package pro.sky.adsonlineapp.service;

import org.springframework.web.multipart.MultipartFile;
import pro.sky.adsonlineapp.dto.NewPassword;
import pro.sky.adsonlineapp.dto.UserDto;
import pro.sky.adsonlineapp.model.User;

/**
 * Сервис по работе с пользователями.
 */
public interface UserService {

    /**
     * Обновление пароля
     *
     * @param password новый пароль
     * @param username информация о пользователе
     * @return true or false
     */
    boolean setPassword(NewPassword password, String username);

    /**
     * Получить информацию об авторизованном пользователе
     *
     * @param username информация о пользователе
     * @return пользователь
     */
    UserDto getUser(String username);

    /**
     * Обновить информацию об авторизованном пользователе
     *
     * @param user     пользователь
     * @param username информация о пользователе
     * @return измененный пользователей
     */
    UserDto updateUser(UserDto user, String username);

    /**
     * Обновить аватар авторизованного пользователя
     *
     * @param username информация о пользователе
     * @param image    новый аватар
     * @return true or false
     */
    boolean updateUserImage(String username, MultipartFile image);

}

