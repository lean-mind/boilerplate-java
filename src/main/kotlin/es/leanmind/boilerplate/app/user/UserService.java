package es.leanmind.boilerplate.app.user;

import es.leanmind.boilerplate.app.passwordRestToken.PasswordDto;
import es.leanmind.boilerplate.app.role.RoleType;


public interface UserService {

    User saveUser(UserDto userDto, RoleType roleType);

    void changeUserPassword(User user, PasswordDto passwordDto);
}
