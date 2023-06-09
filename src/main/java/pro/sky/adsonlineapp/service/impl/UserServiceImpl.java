package pro.sky.adsonlineapp.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pro.sky.adsonlineapp.dto.UserDto;
import pro.sky.adsonlineapp.model.User;
import pro.sky.adsonlineapp.repository.UserRepository;
import pro.sky.adsonlineapp.service.UserService;
import pro.sky.adsonlineapp.utils.MappingUtils;

/**
 * Бизнес-логика по работе с пользователями.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MappingUtils<UserDto, User> userMapper;

    public UserServiceImpl(UserRepository userRepository,
                           MappingUtils<UserDto, User> userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public boolean setPassword(String currentPassword, String newPassword) {
        return false;
    }

    @Override
    public UserDto getUser() {
        // todo: need to return currently logged in user (not the 1st user)
        User user = userRepository.getReferenceById(1);
        if (user != null) {
            return userMapper.mapToDto(user);
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
