package co.edu.cesde.ga.aplicacion.repository.Impl;

import co.edu.cesde.ga.aplicacion.models.Users;
import co.edu.cesde.ga.aplicacion.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryInMemory implements UserRepository {
    private List<Users> usersList = new ArrayList<>();

    @Override
    public void save(Users user) {
        usersList.add(user);
    }

    @Override
    public Optional<Users> findById(Long userId) {
        return usersList.stream()
                .filter(u -> u.getUserId().equals(userId))
                .findFirst();
    }

    @Override
    public Optional<Users> findByUsername(String username) {
        return usersList.stream()
                .filter(u -> u.getName().equalsIgnoreCase(username))
                .findFirst();
    }

    @Override
    public List<Users> findAll() {
        return new ArrayList<>(usersList);
    }

    @Override
    public void update(Users user) {
        // Buscamos el usuario existente por su ID
        findById(user.getUserId()).ifPresent(existingUser -> {
            int index = usersList.indexOf(existingUser);
            usersList.set(index, user);
        });
    }

    @Override
    public void delete(Long userId) {
        usersList.removeIf(u -> u.getUserId().equals(userId));
    }
}