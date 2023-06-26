package pro.sky.adsonlineapp.utils;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.ILoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.adsonlineapp.dto.RegisterReq;
import pro.sky.adsonlineapp.dto.UserDto;
import pro.sky.adsonlineapp.model.User;

import java.io.File;

/**
 * Бизнес-логика по маппингу пользователей (UserDto).
 */
@Service
@Slf4j
public class UserMapperUtils {

//    private final String imagesPath = System.getProperty("user.dir") + File.separator + "images";

    public User mapToEntity(RegisterReq dto){

        User entity = new User();
        entity.setUsername(dto.getUsername());
        entity.setEmail(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPhone(dto.getPhone());
        entity.setRole(dto.getRole());

        return entity;
    }

    public UserDto mapToDto(User entity) {

        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setPhone(entity.getPhone());
        dto.setImage(String.format("/users/image/%s", entity.getImage()));
//        dto.setImage("/users/image/" + entity.getImage());

//        log.info("mapToDto: dto.getImage = {}", dto.getImage());

        return dto;
    }
}
