package es.leanmind.boilerplate.app.user;

import es.leanmind.boilerplate.app.passwordRestToken.PasswordDto;
import es.leanmind.boilerplate.app.role.Role;
import es.leanmind.boilerplate.app.role.RoleRepository;
import es.leanmind.boilerplate.app.role.RoleType;
import es.leanmind.boilerplate.app.userRole.UserRole;
import es.leanmind.boilerplate.exceptions.RoleDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private UserDtoMapper userDtoMapper;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(RoleRepository roleRepository, UserRepository userRepository, UserDtoMapper userDtoMapper,
                           PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.userDtoMapper = userDtoMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User saveUser(UserDto userDto, RoleType roleType) {
        User user = userDtoMapper.toUser(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return setUserRole(user, roleType);
    }

    @Override
    public void changeUserPassword(User user, PasswordDto passwordDto) {
        user.setPassword(passwordDto.getNewPassword());
        user.setLastPasswordResetDate(new Date());
        userRepository.save(user);
    }

    private User setUserRole(User user, RoleType roleType) {
        Optional<Role> optionalRole = roleRepository.findByName(roleType);
        Role role = optionalRole.orElseThrow(() -> new RoleDoesNotExistException("There is no role such as: " + roleType.name()));
        UserRole userRole = new UserRole(user, role);
        user.addUserRole(userRole);
        return userRepository.save(user);
    }
}
