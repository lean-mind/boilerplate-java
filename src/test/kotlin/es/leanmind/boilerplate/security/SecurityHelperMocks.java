package es.leanmind.boilerplate.security;

import es.leanmind.boilerplate.app.passwordRestToken.PasswordResetToken;
import es.leanmind.boilerplate.helper.SecurityHelper;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

public class SecurityHelperMocks {

    public void initMocks(SecurityHelper securityHelper){
        Mockito.doNothing().when(securityHelper)
                .grantUserChangePasswordPrivilege(ArgumentMatchers.any(PasswordResetToken.class));
    }
}
