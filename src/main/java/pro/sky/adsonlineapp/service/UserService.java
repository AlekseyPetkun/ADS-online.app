package pro.sky.adsonlineapp.service;

import org.springframework.web.multipart.MultipartFile;
import pro.sky.adsonlineapp.dto.UserDto;
import pro.sky.adsonlineapp.model.User;

/**
 * Сервис по работе с пользователями.
 */
public interface UserService {

    boolean setPassword(String currentPassword, String newPassword);
    UserDto getUser();
    boolean updateUser(User user);
    boolean updateUserPicture(MultipartFile picture);
}

