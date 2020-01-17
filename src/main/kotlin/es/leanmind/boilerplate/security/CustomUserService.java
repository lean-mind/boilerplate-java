package es.leanmind.boilerplate.security;

import es.leanmind.boilerplate.app.user.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface CustomUserService extends UserDetailsService {
    User loadUserByUsername(String username);
}
