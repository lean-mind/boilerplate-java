package es.leanmind.boilerplate.app.passwordResetToken;

import es.leanmind.boilerplate.app.passwordRestToken.PasswordResetToken;
import es.leanmind.boilerplate.app.passwordRestToken.PasswordResetTokenRepository;
import es.leanmind.boilerplate.app.passwordRestToken.PasswordResetTokenService;
import es.leanmind.boilerplate.app.passwordRestToken.PasswordResetTokenServiceImpl;
import es.leanmind.boilerplate.app.user.MailServiceMocks;
import es.leanmind.boilerplate.app.user.User;
import es.leanmind.boilerplate.app.user.UserStubs;
import es.leanmind.boilerplate.helper.MailService;
import es.leanmind.boilerplate.helper.SecurityHelper;
import es.leanmind.boilerplate.security.SecurityHelperMocks;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class PasswordResetTokenServiceImplTest {

    @MockBean
    private PasswordResetTokenRepository passwordResetTokenRepository;
    @MockBean
    private MailService mailService;
    @MockBean
    private SecurityHelper securityHelper;
    private PasswordResetTokenService passwordResetTokenService;


    PasswordResetTokenMocks passwordResetToken = new PasswordResetTokenMocks();
    MailServiceMocks mailServiceMocks = new MailServiceMocks();
    SecurityHelperMocks securityHelperMocks = new SecurityHelperMocks();
    User user;

    @Before
    public void setUp() throws Exception {
        passwordResetToken.initMocks(passwordResetTokenRepository);
        mailServiceMocks.initMocks(mailService);
        securityHelperMocks.initMocks(securityHelper);
        passwordResetTokenService =
                new PasswordResetTokenServiceImpl(passwordResetTokenRepository, mailService, securityHelper);
        user = UserStubs.generateUser();
    }

    @Test
    public void createPasswordResetTokenForUserShouldCreatePasswordToken() throws Exception {
        passwordResetTokenService.createPasswordResetTokenForUser(user);

        verify(passwordResetTokenRepository).save(ArgumentMatchers.any(PasswordResetToken.class));
        verify(mailService).sendMail(ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString());
    }

    @Test
    public void validatePasswordShouldReturnTrueWhenTokenIsValid() throws Exception {

        boolean valid = passwordResetTokenService.validateResetToken(1L, "token");

        assertThat(valid).isTrue();
        verify(securityHelper).grantUserChangePasswordPrivilege(ArgumentMatchers.any(PasswordResetToken.class));

    }

    @Test
    public void validatePasswordShouldReturnFalseWhenTokenHasExpired() throws Exception {
        Optional<PasswordResetToken> optionalToken = PasswordResetTokenStubs.generateOptionalPasswordResetToken();
        optionalToken.get().setExpiryDate(Instant.now().minusSeconds(84000L));
        when(passwordResetTokenRepository.findByToken(ArgumentMatchers.anyString())).thenReturn(optionalToken);

        boolean valid = passwordResetTokenService.validateResetToken(1L, "token");

        assertThat(valid).isFalse();
    }

    @Test
    public void validatePasswordShouldReturnFalseWhenTokenIsNull() throws Exception {
        when(passwordResetTokenRepository.findByToken(ArgumentMatchers.anyString())).thenReturn(Optional.empty());

        boolean valid = passwordResetTokenService.validateResetToken(1L, "token");

        assertThat(valid).isFalse();
        verify(passwordResetTokenRepository).findByToken(ArgumentMatchers.anyString());
    }

    @Test
    public void validatePasswordShouldReturnFalseWhenIdDontMatch() throws Exception {
        when(passwordResetTokenRepository.findByToken(ArgumentMatchers.anyString())).thenReturn(Optional.empty());

        boolean valid = passwordResetTokenService.validateResetToken(100L, "token");

        assertThat(valid).isFalse();
        verify(passwordResetTokenRepository).findByToken(ArgumentMatchers.anyString());
    }
}