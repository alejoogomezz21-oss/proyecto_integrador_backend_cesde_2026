package co.edu.cesde.ga.aplicacion.repository;

import co.edu.cesde.ga.aplicacion.models.Users;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void save(Users user);
    Optional<Users> findById(Long userId);
    Optional<Users> findByUsername(String username);
    List<Users> findAll();
    void update(Users user);
    void delete(Long userId);
}