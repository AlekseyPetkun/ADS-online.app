package pro.sky.adsonlineapp.components;

import java.util.Collection;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pro.sky.adsonlineapp.model.User;
import pro.sky.adsonlineapp.repository.UserRepository;

/**
 * Преобразование пользователя из БД в security пользователя
 */
@Service
@RequiredArgsConstructor
public class SecurityUser implements UserDetails, UserDetailsService {

    private final UserRepository userRepository;
    @Getter
    private User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getRole().name());
        return List.of(grantedAuthority);
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("Пользователь '%s' не найден!", username));
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                getAuthorities());
    }
}