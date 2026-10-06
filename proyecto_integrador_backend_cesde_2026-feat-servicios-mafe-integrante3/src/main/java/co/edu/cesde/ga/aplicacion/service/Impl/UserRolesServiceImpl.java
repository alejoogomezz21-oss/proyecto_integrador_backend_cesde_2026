package co.edu.cesde.ga.aplicacion.service.Impl;

import co.edu.cesde.ga.aplicacion.models.Roles;
import co.edu.cesde.ga.aplicacion.models.UserRoles;
import co.edu.cesde.ga.aplicacion.models.Users;
import co.edu.cesde.ga.aplicacion.repository.RolesRepository;
import co.edu.cesde.ga.aplicacion.repository.UserRepository;
import co.edu.cesde.ga.aplicacion.repository.UserRolesRepository;
import co.edu.cesde.ga.aplicacion.service.UserRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRolesServiceImpl implements UserRolesService {

    private final UserRolesRepository userRolesRepository;
    private final UserRepository usersRepository;
    private final RolesRepository rolesRepository;

    @Autowired
    public UserRolesServiceImpl(UserRolesRepository userRolesRepository,
                                UserRepository usersRepository,
                                RolesRepository rolesRepository) {
        this.userRolesRepository = userRolesRepository;
        this.usersRepository = usersRepository;
        this.rolesRepository = rolesRepository;
    }

    @Override
    public void assignRole(Long userId, Long roleId) {
        // 1. Buscamos el usuario completo en la base de datos
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // 2. Buscamos el rol completo en la base de datos
        Roles role = rolesRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        // 3. Creamos la instancia de UserRoles y le asignamos los OBJETOS completos
        UserRoles userRole = new UserRoles();
        userRole.setUser(user);   // Le pasamos el objeto Users
        userRole.setRole(role);   // Le pasamos el objeto Roles

        // 4. Guardamos
        userRolesRepository.save(userRole);
    }

    @Override
    public List<UserRoles> getRolesByUserId(Long userId) {
        return userRolesRepository.findByUser_Id(userId);
    }

    @Override
    public List<UserRoles> getAllAssignments() {
        return userRolesRepository.findAll();
    }

    @Override
    public void removeRoleFromUser(Long userId, Long roleId) {

        List<UserRoles> roles = userRolesRepository.findByUser_Id(userId);
        for (UserRoles ur : roles) {
            // Ajusta getRoleId() según el método que tenga tu modelo UserRoles
            if (ur.getRoleId().getId().equals(roleId)) {
                userRolesRepository.delete(ur);
                break;
            }
        }
    }
}