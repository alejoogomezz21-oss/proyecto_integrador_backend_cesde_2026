package co.edu.cesde.ga.aplicacion.service.Impl;

import co.edu.cesde.ga.aplicacion.models.UserRoles;
import co.edu.cesde.ga.aplicacion.repository.UserRolesRepository;
import co.edu.cesde.ga.aplicacion.service.UserRolesService;
import java.util.List;

public class UserRolesServiceImpl implements UserRolesService {


    private final UserRolesRepository userRolesRepository;


    public UserRolesServiceImpl(UserRolesRepository userRolesRepository) {
        this.userRolesRepository = userRolesRepository;
    }

    @Override
    public void assignRole(Long userId, Long roleId) {

        UserRoles userRole = new UserRoles(userId, roleId);
        userRolesRepository.save(userRole);
    }

    @Override
    public List<UserRoles> getRolesByUserId(Long userId) {

        return userRolesRepository.findByUserId(userId);
    }

    @Override
    public List<UserRoles> getAllAssignments() {

        return userRolesRepository.findAll();
    }

    @Override
    public void removeRoleFromUser(Long userId, Long roleId) {

        userRolesRepository.delete(userId, roleId);
    }
}
