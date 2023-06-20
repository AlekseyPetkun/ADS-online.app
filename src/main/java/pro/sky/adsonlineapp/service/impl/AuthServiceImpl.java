package pro.sky.adsonlineapp.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pro.sky.adsonlineapp.components.JpaUserDetailsService;
import pro.sky.adsonlineapp.components.SecurityUser;
import pro.sky.adsonlineapp.dto.RegisterReq;
import pro.sky.adsonlineapp.constants.Role;
import pro.sky.adsonlineapp.exceptions.ValidationException;
import pro.sky.adsonlineapp.model.User;
import pro.sky.adsonlineapp.repository.UserRepository;
import pro.sky.adsonlineapp.service.AuthService;
import pro.sky.adsonlineapp.service.ValidationService;
import pro.sky.adsonlineapp.utils.UserMapperUtils;

/**
 * Бизнес-логика по работе с аутентификацией.
 */
@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    //    private final UserDetailsManager manager;
    //  private final UserDetailsService manager;
//  private final JdbcUserDetailsManager manager;
    private final PasswordEncoder encoder;
    private final UserMapperUtils mapp;
    private final UserRepository userRepository;
    private final ValidationService validationService;
    private final SecurityUser securityUser;
    //    private final JpaUserDetailsService jpaUserDetailsService;
    private final UserDetailsService userDetailsService;


    @Override
    public boolean login(String userName, String password) {
//    UserDetails foundUser = manager.loadUserByUsername(userName);
//    String encryptedPassword = foundUser.getPassword();
//    return encoder.matches(password, encryptedPassword);

//        if (!manager.userExists(userName)) {
//            return false;
//        }
        User user = userRepository.findByUsername(userName);
        if (user == null
                || !user.getUsername().equals(userName)
                && !user.getPassword().equals(encoder.encode(password))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
        return encoder.matches(password, userDetails.getPassword());
    }

    @Override
    public boolean register(RegisterReq registerReq, Role role) {

        User user = userRepository.findByUsername(registerReq.getUsername());
        if (user != null) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

        if (!validationService.validate(registerReq)) {
            throw new ValidationException(registerReq.toString());
        }

        try {
            registerReq.setRole(role);
            registerReq.setPassword(encoder.encode(registerReq.getPassword()));
            User newUser = mapp.mapToUserEntity(registerReq);
            userRepository.save(newUser);
            return true;
        } catch (RuntimeException e) {
            e.getStackTrace();
            return false;
        }

//        if (manager.userExists(registerReq.getUsername())) {
//            return false;
//        }
//        manager.createUser(
//                User.builder()
//                        .passwordEncoder(this.encoder::encode)
//                        .password(registerReq.getPassword())
//                        .username(registerReq.getUsername())
//                        .roles(role.name())
//                        .build());

//        return true;
    }

}
