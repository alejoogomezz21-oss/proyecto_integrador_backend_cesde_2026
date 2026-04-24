package co.edu.cesde.ga.aplicacion.repository.Impl;

import co.edu.cesde.ga.aplicacion.models.Roles;
import co.edu.cesde.ga.aplicacion.repository.RolesRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoleRepositoryInMemory implements RolesRepository {
    private List<Roles> rolesList = new ArrayList<>();

    @Override
    public void save(Roles role) {
        rolesList.add(role);
    }

    @Override
    public Optional<Roles> findById(Long roleId) {
        return rolesList.stream()
                .filter(r -> r.getRoleId().equals(roleId))
                .findFirst();
    }

    @Override
    public Optional<Roles> findByName(String name) {
        return rolesList.stream()
                .filter(r -> r.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    @Override
    public List<Roles> findAll() {
        return new ArrayList<>(rolesList);
    }

    @Override
    public void delete(Long roleId) {
        rolesList.removeIf(r -> r.getRoleId().equals(roleId));
    }
}
