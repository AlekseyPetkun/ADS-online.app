package pro.sky.adsonlineapp.components;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pro.sky.adsonlineapp.model.User;
import pro.sky.adsonlineapp.repository.UserRepository;

import static pro.sky.adsonlineapp.constants.AuthMessages.USER_NOT_FOUND_MSG;

//@Service
//@RequiredArgsConstructor
public class JpaUserDetailsService {

//    private final UserRepository userRepository;
//    private final SecurityUser securityUser;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User userFromDb = userRepository.findByUsername(username);
//
//        securityUser.setUser(userFromDb);
//        return securityUser;
//    }
//    private final PasswordEncoder encoder;


//    @Override
//    public UserDetails loadUserByUsername(String email) {
//        User userFromDb = userRepository.findByUsername(email)
////                .orElseThrow(() -> new UsernameNotFoundException(USER_NOT_FOUND_MSG));
//
//        securityUser.setUser(userFromDb);
//        return securityUser;

//    }

//    public boolean userExists(String email) {
//        return userRepository.existsByEmail(email);
//    }
//
//    public User saveUser(RegisterReq registerReq) {
//        User user = mapper.toUserEntity(registerReq);
//        user.setPassword(encoder.encode(registerReq.getPassword()));
//        return userRepository.save(user);
//    }
}
