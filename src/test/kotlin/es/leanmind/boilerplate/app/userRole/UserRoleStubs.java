package es.leanmind.boilerplate.app.userRole;

import es.leanmind.boilerplate.app.role.Role;
import es.leanmind.boilerplate.app.role.RoleStubs;
import es.leanmind.boilerplate.app.user.User;
import es.leanmind.boilerplate.app.user.UserStubs;

import java.util.ArrayList;
import java.util.List;

public class UserRoleStubs {
    public static UserRole generateUserRole(){
        User user = UserStubs.generateUserWithNoRole();
        Role role = RoleStubs.generateRole();
        return new UserRole(user, role);
    }

    public static List<UserRole> generateUserRoles(){
        List<UserRole> userRoles = new ArrayList<>();
        userRoles.add(generateUserRole());
        return userRoles;
    }
}
