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
     * @param currentPassword старый пароль
     * @param newPassword     новый пароль
     * @return обновленный пароль
     */
    boolean setPassword(NewPassword password, String username);

    /**
     * Получить информацию об авторизованном пользователе
     *
     * @return информация о пользователе
     */
    UserDto getUser(String username);

    /**
     * Обновить информацию об авторизованном пользователе
     *
     * @param user пользователь
     * @return true or false
     */
    UserDto updateUser(UserDto user, String username);

    /**
     * Обновить аватар авторизованного пользователя
     *
     * @param image аватар
     * @return true or false
     */
    boolean updateUserImage(String username, MultipartFile image);

}

