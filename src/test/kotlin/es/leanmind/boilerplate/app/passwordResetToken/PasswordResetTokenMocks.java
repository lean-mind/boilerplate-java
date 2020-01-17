package es.leanmind.boilerplate.app.passwordResetToken;

import es.leanmind.boilerplate.app.passwordRestToken.PasswordResetToken;
import es.leanmind.boilerplate.app.passwordRestToken.PasswordResetTokenRepository;
import org.mockito.ArgumentMatchers;

import static org.mockito.Mockito.when;

public class PasswordResetTokenMocks {
    public void initMocks(PasswordResetTokenRepository passwordResetTokenRepository){
        when(passwordResetTokenRepository.save(ArgumentMatchers.any(PasswordResetToken.class)))
                .thenReturn(PasswordResetTokenStubs.generatePasswordResetToken());
        when(passwordResetTokenRepository.findByToken(ArgumentMatchers.anyString()))
                .thenReturn(PasswordResetTokenStubs.generateOptionalPasswordResetToken());
    }
}
