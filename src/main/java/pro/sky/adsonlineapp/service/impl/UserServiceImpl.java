package pro.sky.adsonlineapp.service.impl;

import pro.sky.adsonlineapp.dto.UserDto;
import pro.sky.adsonlineapp.model.User;
import pro.sky.adsonlineapp.repository.UserRepository;
import pro.sky.adsonlineapp.service.UserService;
import pro.sky.adsonlineapp.utils.impl.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


        /**
        * Сервис для работы с Пользователями
        */
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
            public boolean updateUserPicture(MultipartFile picture) {
                return false;
            }

            @Override
            public boolean updateUserImage(MultipartFile image) {
                return false;
            }
        }
