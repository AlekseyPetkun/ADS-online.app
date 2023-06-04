package pro.sky.adsonlineapp.dto;

import lombok.Data;

@Data
public class UserDto {

    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String image;
}
