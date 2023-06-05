package pro.sky.adsonlineapp.utils.impl;
import org.springframework.stereotype.Service;
import pro.sky.adsonlineapp.dto.User;
import pro.sky.adsonlineapp.model.UserEntity;
import pro.sky.adsonlineapp.dto.RegisterReq;


@Service
public class UserMapper {
    /**
     * Dto -> entity mapping
     * @param dto input dto class
     * @return entity class
     */
    public UserEntity mapToUserEntity(RegisterReq dto){
        UserEntity entity = new UserEntity();
        entity.setEmail(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPhone(dto.getPhone());
        entity.setRole(dto.getRole());
        return entity;
    }

    /**
     * Entity -> dto mapping
     * @param entity input entity class
     * @return dto class
     */
    public User mapToUserDto(UserEntity entity) {
        User dto = new User();
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setPhone(entity.getPhone());
        dto.setImage(entity.getImage());
        return dto;
    }
}
