package es.leanmind.boilerplate.app.passwordResetToken;

import es.leanmind.boilerplate.app.passwordRestToken.PasswordResetToken;
import es.leanmind.boilerplate.app.user.User;
import es.leanmind.boilerplate.app.user.UserStubs;

import java.util.Optional;
import java.util.UUID;

public class PasswordResetTokenStubs {

    public static Optional<PasswordResetToken> generateOptionalPasswordResetToken() {
        User user = UserStubs.generateUser();
        user.setId(1L);
        PasswordResetToken passwordResetToken =
                new PasswordResetToken(UUID.randomUUID().toString(), user);
        return Optional.of(passwordResetToken);
    }

    public static PasswordResetToken generatePasswordResetToken() {
        User user = UserStubs.generateUser();
        user.setId(1L);
        PasswordResetToken passwordResetToken = new PasswordResetToken(UUID.randomUUID().toString(), user);
        return passwordResetToken;
    }
}
