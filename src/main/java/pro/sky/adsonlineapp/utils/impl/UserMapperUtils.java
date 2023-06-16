package pro.sky.adsonlineapp.utils.impl;

import org.springframework.stereotype.Service;
import pro.sky.adsonlineapp.dto.UserDto;
import pro.sky.adsonlineapp.model.User;
import pro.sky.adsonlineapp.utils.MappingUtils;

/**
 * Бизнес-логика по маппингу пользователей (UserDto).
 */
@Service
public class UserMapperUtils {

    public User mapToEntity(UserDto dto) {

        User entity = new User();
        entity.setId(dto.getId());

      //entity.setUserName(dto.getUserName());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPhone(dto.getPhone());
        //entity.setPicture(dto.getPicture);

      return entity;
    }

    public UserDto mapToDto(User entity) {

        UserDto dto = new UserDto();
        dto.setId(entity.getId());

        //dto.setUserName(entity.getUserName());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setPhone(entity.getPhone());
        //dto.setPicture(entity.getPicture());

        return dto;
    }
}
