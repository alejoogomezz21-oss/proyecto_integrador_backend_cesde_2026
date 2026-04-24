package co.edu.cesde.ga.aplicacion.repository.Impl;

import co.edu.cesde.ga.aplicacion.models.Groups;
import co.edu.cesde.ga.aplicacion.repository.GroupsRepository;

import java.util.ArrayList;

import java.util.List;

public class GroupsRepositoryInMemory  implements GroupsRepository{

    private List<Groups> groupsList = new ArrayList<>();

    @Override
    public Groups create(Groups group) {
        groupsList.add(group);
        return group;
    }

    @Override
    public boolean delete(Long groupId) {
        return groupsList.removeIf(group -> group.getGroupId().equals(groupId));
    }

    @Override
    public boolean update(Groups groupUpdate) {
        for (int i = 0; i < groupsList.size(); i++) {
            if (groupsList.get(i).getGroupId().equals(groupUpdate.getGroupId())) {
                groupsList.set(i, groupUpdate);
                return true;
            }
        }
        return false;
    }

    @Override
    public Groups findById(Long groupId) {
        return groupsList.stream()
                .filter(group -> group.getGroupId().equals(groupId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Groups> findAll() {
        return groupsList;
    }

    @Override
    public boolean existsById(Long groupId) {
        return groupsList.stream()
                .anyMatch(group -> group.getGroupId().equals(groupId));
    }


}
