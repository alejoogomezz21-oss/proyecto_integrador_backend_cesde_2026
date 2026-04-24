package co.edu.cesde.ga.aplicacion.repository.Impl;

import co.edu.cesde.ga.aplicacion.models.GroupSubjects;
import co.edu.cesde.ga.aplicacion.repository.GroupSubjectsRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GroupSubjectRepositoryInMemory implements GroupSubjectsRepository {
    private List<GroupSubjects> list = new ArrayList<>();

    @Override
    public void save(GroupSubjects groupSubject) {
        list.add(groupSubject);
    }

    @Override
    public Optional<GroupSubjects> findById(Long id) {
        return list.stream().filter(gs -> gs.getId().equals(id)).findFirst();
    }

    @Override
    public List<GroupSubjects> findByGroupId(Long groupId) {
        return list.stream()
                .filter(gs -> gs.getGroupId().equals(groupId))
                .collect(Collectors.toList());
    }

    @Override
    public List<GroupSubjects> findAll() {
        return new ArrayList<>(list);
    }

    @Override
    public void delete(Long id) {
        list.removeIf(gs -> gs.getId().equals(id));
    }
}
