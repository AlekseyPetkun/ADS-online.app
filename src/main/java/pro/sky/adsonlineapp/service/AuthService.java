package pro.sky.adsonlineapp.service;

import pro.sky.adsonlineapp.dto.RegisterReq;
import pro.sky.adsonlineapp.constants.Role;

public interface AuthService {
    boolean login(String userName, String password);
    boolean register(RegisterReq registerReq, Role role);
}
