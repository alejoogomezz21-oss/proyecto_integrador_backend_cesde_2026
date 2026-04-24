package co.edu.cesde.ga.aplicacion.service.Impl;

import co.edu.cesde.ga.aplicacion.models.Users;
import co.edu.cesde.ga.aplicacion.repository.UserRepository;
import co.edu.cesde.ga.aplicacion.service.UserService;
import java.util.List;

public class UserServiceImpl implements UserService {

    // Dependencia del repositorio
    private final UserRepository userRepository;

    // Inyección por constructor
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(Users user) {
        // Aquí podrías agregar validaciones (ej. si el username ya existe)
        userRepository.save(user);
    }

    @Override
    public Users getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Users getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateUserInfo(Users user) {
        userRepository.update(user);
    }

    @Override
    public void removeUser(Long id) {
        userRepository.delete(id);
    }
}
