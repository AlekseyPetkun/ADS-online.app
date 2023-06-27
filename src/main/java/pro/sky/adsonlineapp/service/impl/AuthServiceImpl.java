package pro.sky.adsonlineapp.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
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

    private final PasswordEncoder encoder;
    private final UserMapperUtils userMapperUtils;
    private final UserRepository userRepository;
    private final ValidationService validationService;
    private final UserDetailsService userDetailsService;

    @Override
    public boolean login(String userName, String password) {

        User user = userRepository.findByUsername(userName);

        if (user == null
                || !user.getUsername().equals(userName)
                && !user.getPassword().equals(encoder.encode(password))) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
        return encoder.matches(password, userDetails.getPassword());
    }

    @Override
    public boolean register(RegisterReq registerReq, Role role) {

        User user = userRepository.findByUsername(registerReq.getUsername());
        if (user != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        if (!validationService.validate(registerReq)) {
            throw new ValidationException(registerReq.toString());
        }

        try {
            registerReq.setRole(role);
            registerReq.setPassword(encoder.encode(registerReq.getPassword()));
            User newUser = userMapperUtils.mapToEntity(registerReq);
            userRepository.save(newUser);
            return true;
        } catch (RuntimeException e) {
            e.getStackTrace();
            return false;
        }
    }
}
