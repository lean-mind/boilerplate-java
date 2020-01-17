package es.leanmind.boilerplate.app.auth;

import es.leanmind.boilerplate.app.user.User;
import es.leanmind.boilerplate.security.CustomUserService;
import es.leanmind.boilerplate.security.JwtTokenUtil;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

@RestController
@Api(value = "Authentication", description = "Operations that handle user authentication")
public class AuthController {

    private Logger logger = LoggerFactory.getLogger(AuthController.class);
    @Value("${jwt.header}")
    private String tokenHeader;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomUserService customUserService;

    @GetMapping(value = "/user")
    public User getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader).substring(7);
        logger.info("Retrieved token: '{}'", token);
        String email = jwtTokenUtil.getEmailFromToken(token);
        logger.info("Retrieved user from token: '{}'", email);
        return customUserService.loadUserByUsername(email);
    }

    @PostMapping(value = "${jwt.route.authentication.path}")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AccountCredentials accountCredentials) {
        authenticateUser(accountCredentials);
        final User userDetails = customUserService.loadUserByUsername(accountCredentials.getEmail());
        logger.info("Loaded user details: '{}' '{}'", userDetails);
        final String token = jwtTokenUtil.generateToken(userDetails);
        logger.info("Generated token: '{}'", token);
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    @GetMapping(value = "${jwt.route.authentication.refresh}")
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String authToken = request.getHeader(tokenHeader);
        final String token = authToken.substring(7);
        String email = jwtTokenUtil.getEmailFromToken(token);
        User user = customUserService.loadUserByUsername(email);
        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            String refreshedToken = jwtTokenUtil.refreshToken(token);
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    private void authenticateUser(@NotNull AccountCredentials accountCredentials) throws AuthenticationException {
        String email = accountCredentials.getEmail(), password = accountCredentials.getPassword();
        logger.info("Authenticating with the following email and password: '{}' '{}'", email, password);
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        logger.info("Authenticated with email: '{}' '{}'", email, password);
    }
}
