package co.edu.cesde.ga.aplicacion.service.Impl;

import co.edu.cesde.ga.aplicacion.models.Roles;
import co.edu.cesde.ga.aplicacion.repository.RolesRepository;
import co.edu.cesde.ga.aplicacion.service.RolesService;
import java.util.List;

public class RolesServiceImpl implements RolesService {

    private final RolesRepository roleRepository;


    public RolesServiceImpl(RolesRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void createRole(Roles role) {

        roleRepository.save(role);
    }

    @Override
    public Roles getRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public Roles getRoleByName(String name) {
        return roleRepository.findByName(name).orElse(null);
    }

    @Override
    public List<Roles> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.delete(id);
    }
}
