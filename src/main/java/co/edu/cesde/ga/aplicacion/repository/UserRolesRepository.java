package co.edu.cesde.ga.aplicacion.repository;

import co.edu.cesde.ga.aplicacion.models.UserRoles;
import java.util.List;

public interface UserRolesRepository {


    void save(UserRoles userRole);


    List<UserRoles> findAll();


    List<UserRoles> findByUserId(Long userId);


    void delete(Long userId, Long roleId);
}