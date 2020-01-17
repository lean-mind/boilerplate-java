package es.leanmind.boilerplate.security;

import es.leanmind.boilerplate.app.user.User;
import es.leanmind.boilerplate.app.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
public class JwtUserDetailsService implements CustomUserService {

    private UserRepository userRepository;

    @Autowired
    public JwtUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.getByEmailAndDeletedFalse(username);
        return optionalUser.map(this::reflectLogin)
                .orElseThrow(() -> new UsernameNotFoundException("User with  '" + username + "' email not found."));
    }

    private User reflectLogin(User user) {
        user.setLastLogin(LocalDateTime.now());
        return userRepository.save(user);
    }
}
