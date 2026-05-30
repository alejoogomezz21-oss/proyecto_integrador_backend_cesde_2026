package co.edu.cesde.ga.aplicacion.repository.Impl;

import co.edu.cesde.ga.aplicacion.models.GroupsSubjects;
import co.edu.cesde.ga.aplicacion.repository.GroupSubjectsRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GroupSubjectsRepositoryInMemory implements GroupSubjectsRepository {
    private List<GroupsSubjects> list = new ArrayList<>();

    @Override
    public void save(GroupsSubjects groupSubject) {
        list.add(groupSubject);
    }

    @Override
    public Optional<GroupsSubjects> findById(Long id) {
        return list.stream()
                .filter(gs -> gs.getGroupSubjectId().equals(id))
                .findFirst();
    }

    @Override
    public List<GroupsSubjects> findByGroupId(Long groupId) {
        return list.stream()
                .filter(gs -> gs.getGroupId().equals(groupId))
                .collect(Collectors.toList());
    }

    @Override
    public List<GroupsSubjects> findAll() {
        return new ArrayList<>(list);
    }

    @Override
    public void delete(Long id) {
        list.removeIf(gs -> gs.getGroupSubjectId().equals(id));
    }
}