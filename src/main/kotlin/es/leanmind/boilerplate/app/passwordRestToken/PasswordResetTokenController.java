package es.leanmind.boilerplate.app.passwordRestToken;

import es.leanmind.boilerplate.app.user.User;
import es.leanmind.boilerplate.utils.SecurityUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/passwordResetToken")
@Api(value = "Reset Password")
public class PasswordResetTokenController {

    private PasswordResetTokenService passwordResetTokenService;

    @Autowired
    public PasswordResetTokenController(PasswordResetTokenService passwordResetTokenService) {
        this.passwordResetTokenService = passwordResetTokenService;
    }

    @PostMapping(value = "/resetPassword")
    public ResponseEntity<?> resetPassword() throws Exception {
        User user = SecurityUtils.getLoggedInUser();
        passwordResetTokenService.createPasswordResetTokenForUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //If successfully validated, then the user can update his password.
    @PostMapping(value = "/validateToken")
    public ResponseEntity<Boolean> validateUserPassword(@RequestParam("userId") long userId,
                                                        @RequestParam("token") String token) {
        boolean valid = passwordResetTokenService.validateResetToken(userId, token);
        return new ResponseEntity<>(valid, HttpStatus.OK);
    }

}
