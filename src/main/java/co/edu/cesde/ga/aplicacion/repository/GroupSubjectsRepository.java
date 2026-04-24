package co.edu.cesde.ga.aplicacion.repository;

import co.edu.cesde.ga.aplicacion.models.GroupSubjects;
import java.util.List;
import java.util.Optional;

public interface GroupSubjectsRepository {
    void save(GroupSubjects groupSubject);
    Optional<GroupSubjects> findById(Long id);
    List<GroupSubjects> findByGroupId(Long groupId);
    List<GroupSubjects> findAll();
    void delete(Long id);
}
