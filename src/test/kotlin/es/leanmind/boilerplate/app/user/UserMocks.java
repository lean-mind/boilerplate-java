package es.leanmind.boilerplate.app.user;

import es.leanmind.boilerplate.app.role.RoleType;
import org.mockito.ArgumentMatchers;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class UserMocks {
    public void initMocks(UserRepository userRepository){
        when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(UserStubs.generateUser());
        when(userRepository.getByEmailAndDeletedFalse(ArgumentMatchers.anyString())).thenReturn(UserStubs.generateOptionalUser());
    }
    public void initUserServiceMocks(UserService userService){
        when(doNothing().when(userService).saveUser(ArgumentMatchers.any(UserDto.class), ArgumentMatchers.any(RoleType.class)));
    }
}
