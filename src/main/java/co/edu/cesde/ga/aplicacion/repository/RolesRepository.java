package co.edu.cesde.ga.aplicacion.repository;

import co.edu.cesde.ga.aplicacion.models.Roles;
import java.util.List;
import java.util.Optional;

public interface RolesRepository {
    void save(Roles role);
    Optional<Roles> findById(Long roleId);
    Optional<Roles> findByName(String name);
    List<Roles> findAll();
    void delete(Long roleId);
}
