package SpringBootCrudApp.service.roleService;

import SpringBootCrudApp.model.Role;

import java.util.Collection;

public interface RoleService {
    void addRole(String role);
    Role getRoleById(long id);
    Collection<Role> getAllRoles();
    boolean deleteRoleById(long id);
}
