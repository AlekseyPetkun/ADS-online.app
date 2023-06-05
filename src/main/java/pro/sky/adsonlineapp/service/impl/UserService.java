package pro.sky.adsonlineapp.service.impl;

import org.springframework.web.multipart.MultipartFile;
import pro.sky.adsonlineapp.dto.User;
public interface UserService {
    boolean setPassword(String currentPassword, String newPassword);
    User getUser();
    boolean updateUser(User user);
    boolean updateUserImage(MultipartFile image);
}
