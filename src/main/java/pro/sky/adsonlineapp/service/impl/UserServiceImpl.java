package pro.sky.adsonlineapp.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pro.sky.adsonlineapp.dto.User;
import pro.sky.adsonlineapp.model.UserEntity;
import pro.sky.adsonlineapp.repository.UserRepository;
import pro.sky.adsonlineapp.utils.impl.UserMapper;




@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public boolean setPassword(String currentPassword, String newPassword) {
        return false;
    }

    @Override
    public User getUser() {
        // todo: need to return currently logged in user (not the 1st user)
        UserEntity user = userRepository.findById(1).orElse(null);
        if (user != null) {
            return userMapper.mapToUserDto(user);
        } else {
            return null;
        }
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public boolean updateUserImage(MultipartFile image) {
        return false;
    }
}
