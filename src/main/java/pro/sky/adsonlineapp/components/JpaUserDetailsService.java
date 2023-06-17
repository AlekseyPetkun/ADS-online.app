package pro.sky.adsonlineapp.components;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pro.sky.adsonlineapp.dto.RegisterReq;
import pro.sky.adsonlineapp.mapper.Mapper;
import  pro.sky.adsonlineapp.model.User;
import pro.sky.adsonlineapp.repository.UserRepository;

import static pro.sky.adsonlineapp.exceptions.message.AuthMessages.USER_NOT_FOUND_MSG;

@Service
@RequiredArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final Mapper mapper;
    private final PasswordEncoder encoder;


    @Override
    public UserDetails loadUserByUsername(String email) {
        User userFromDb = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(USER_NOT_FOUND_MSG));
        return new SecurityUser(userFromDb);
    }

    public boolean userExists(String email) {
        return userRepository.existsByEmail(email);
    }

    public User saveUser(RegisterReq registerReq) {
        User user = mapper.toUserEntity(registerReq);
        user.setPassword(encoder.encode(registerReq.getPassword()));
        return userRepository.save(user);
    }
}
