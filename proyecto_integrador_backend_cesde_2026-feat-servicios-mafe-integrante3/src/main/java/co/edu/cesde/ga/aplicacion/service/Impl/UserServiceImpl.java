package co.edu.cesde.ga.aplicacion.service.Impl;

import co.edu.cesde.ga.aplicacion.models.Users;
import co.edu.cesde.ga.aplicacion.repository.UserRepository;
import co.edu.cesde.ga.aplicacion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(Users user) {
        userRepository.save(user);
    }

    @Override
    public Users getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Users getUserByUsername(String username) {
        // Usamos findByEmail para buscar por el correo registrado
        return userRepository.findByEmail(username).orElse(null);
    }

    @Override
    public Users getUserByIdentification(String identification) {
        return userRepository.findByIdentification(identification).orElse(null);
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateUserInfo(Users user) {
        userRepository.save(user);
    }

    @Override
    public void removeUser(Long id) {
        userRepository.deleteById(id);
    }
}