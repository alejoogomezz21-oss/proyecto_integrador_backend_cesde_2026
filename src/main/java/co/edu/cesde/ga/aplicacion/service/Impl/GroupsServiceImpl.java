package co.edu.cesde.ga.aplicacion.service.Impl;

import co.edu.cesde.ga.aplicacion.service.GroupsService;
import co.edu.cesde.ga.aplicacion.models.Groups;
import co.edu.cesde.ga.aplicacion.repository.GroupsRepository;
import co.edu.cesde.ga.aplicacion.repository.Impl.GroupsRepositoryInMemory;

import java.util.List;

public class GroupsServiceImpl implements GroupsRepository {

    private final GroupsRepository groupsRepository;

    public GroupsServiceImpl() {
        this.groupsRepository = new GroupsRepositoryInMemory();
    }

    @Override
    public Groups create(Groups group) {
        return groupsRepository.create(group);
    }

    @Override
    public boolean delete(Long groupId) {
        return groupsRepository.delete(groupId);
    }

    @Override
    public boolean update(Groups groupUpdate) {
        return groupsRepository.update(groupUpdate);
    }

    @Override
    public Groups findById(Long groupId) {
        return groupsRepository.findById(groupId);
    }

    @Override
    public List<Groups> findAll() {
        return groupsRepository.findAll();
    }

    @Override
    public boolean existsById(Long groupId) {
        return groupsRepository.existsById(groupId);
    }

}
