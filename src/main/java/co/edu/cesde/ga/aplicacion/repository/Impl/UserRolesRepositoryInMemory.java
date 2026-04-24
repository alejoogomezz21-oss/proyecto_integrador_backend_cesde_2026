package co.edu.cesde.ga.aplicacion.repository.Impl;

import co.edu.cesde.ga.aplicacion.models.UserRoles;
import co.edu.cesde.ga.aplicacion.repository.UserRolesRepository;
import java.util.ArrayList;
import java.util.List;

public class UserRolesRepositoryInMemory implements UserRolesRepository {
    private List<UserRoles> userRolesList = new ArrayList<>();

    @Override
    public void save(UserRoles userRole) {
        userRolesList.add(userRole);
    }

    @Override
    public List<UserRoles> findAll() {
        return userRolesList;
    }

    @Override
    public List<UserRoles> findByUserId(Long userId) {
        return List.of();
    }

    @Override
    public void delete(Long userId, Long roleId) {

    }
}
