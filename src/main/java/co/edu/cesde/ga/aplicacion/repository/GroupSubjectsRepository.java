package co.edu.cesde.ga.aplicacion.repository;

import co.edu.cesde.ga.aplicacion.models.GroupsSubjects;

import java.util.List;
import java.util.Optional;

public interface GroupSubjectsRepository {
    void save(GroupsSubjects groupSubject);
    Optional<GroupsSubjects> findById(Long id);
    List<GroupsSubjects> findByGroupId(Long groupId);
    List<GroupsSubjects> findAll();
    void delete(Long id);
}
