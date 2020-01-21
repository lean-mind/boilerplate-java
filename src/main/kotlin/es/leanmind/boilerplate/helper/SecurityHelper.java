package es.leanmind.boilerplate.helper;

import es.leanmind.boilerplate.app.passwordRestToken.PasswordResetToken;
import es.leanmind.boilerplate.app.user.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import static java.util.Collections.singletonList;

@Component
public class SecurityHelper {
    public SecurityHelper() {
    }

    public void grantUserChangePasswordPrivilege(PasswordResetToken passwordResetToken) {
        User user = passwordResetToken.getUser();
        Authentication auth = new UsernamePasswordAuthenticationToken(user, null,
            singletonList(new SimpleGrantedAuthority("CHANGE_PASSWORD_PRIVILEGE")));
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}
