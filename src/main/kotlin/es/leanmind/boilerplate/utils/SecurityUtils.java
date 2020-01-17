package es.leanmind.boilerplate.utils;

import es.leanmind.boilerplate.app.user.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityUtils {
    public static User getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ((User) authentication.getPrincipal());
    }
}
