package pro.sky.adsonlineapp.service.impl;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pro.sky.adsonlineapp.dto.UserDto;
import pro.sky.adsonlineapp.model.User;
import pro.sky.adsonlineapp.repository.UserRepository;
import pro.sky.adsonlineapp.service.UserService;
import pro.sky.adsonlineapp.utils.impl.UserMapperUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;


/**
 * Бизнес-логика по работе с пользователями.
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapperUtils userMapper;

    @Override
    public boolean setPassword(String currentPassword, String newPassword) {
        return false;
    }

    @Override
    public UserDto getUser() {

        User user = userRepository.findById(1).orElse(null);
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

