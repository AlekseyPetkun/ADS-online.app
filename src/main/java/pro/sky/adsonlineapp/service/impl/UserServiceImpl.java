package pro.sky.adsonlineapp.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import pro.sky.adsonlineapp.dto.NewPassword;
import pro.sky.adsonlineapp.dto.UserDto;
import pro.sky.adsonlineapp.exceptions.CurrentPasswordNotMatch;
import pro.sky.adsonlineapp.exceptions.NotFoundEntityException;
import pro.sky.adsonlineapp.model.User;
import pro.sky.adsonlineapp.repository.UserRepository;
import pro.sky.adsonlineapp.service.UserService;
import pro.sky.adsonlineapp.utils.UserMapperUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import static pro.sky.adsonlineapp.constants.Message.*;


/**
 * Бизнес-логика по работе с пользователями.
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapperUtils userMapper;
    private final PasswordEncoder encoder;

    @Override
    @Transactional
    public boolean setPassword(NewPassword password, String username) {

        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new NotFoundEntityException(NOT_FOUND_ENTITY);
        }

        if (user.getPassword().equals(encoder.encode(password.getCurrentPassword()))) {
            userRepository.updatePassword(user.getId(), encoder.encode(password.getNewPassword()));
            return true;
        } else {
            throw new CurrentPasswordNotMatch("Старые пароли не совпадают!");
        }

    }

    @Override
    public UserDto getUser(String username) {

        User user = userRepository.findByUsername(username);
        if (user != null) {
            return userMapper.mapToDto(user);
        } else {
            throw new NotFoundEntityException(NOT_FOUND_ENTITY);
        }
    }

    @Override
    @Transactional
    public UserDto updateUser(UserDto user, String username) {

        User userDB = userRepository.findByUsername(username);
        User userEntity = userRepository.updateUser(
                user.getFirstName(),
                user.getLastName(),
                user.getPhone(),
                user.getEmail(),
                user.getImage(),
                userDB.getId());

        return userMapper.mapToDto(userEntity);

    }

    @Override
    public boolean updateUserImage(MultipartFile image) {
        return false;
    }

    //  @Override
    //  public boolean updateUserPicture(MultipartFile image) {
    // return false;
    // }

}

