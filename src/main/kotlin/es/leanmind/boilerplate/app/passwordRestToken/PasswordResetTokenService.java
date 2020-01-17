package es.leanmind.boilerplate.app.passwordRestToken;

import es.leanmind.boilerplate.app.user.User;

import javax.mail.MessagingException;

public interface PasswordResetTokenService {
    void createPasswordResetTokenForUser(User user) throws MessagingException;

    boolean validateResetToken(Long userId, String token);
}
