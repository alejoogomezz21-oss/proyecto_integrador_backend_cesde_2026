package co.edu.cesde.ga.aplicacion.service.Impl;

import co.edu.cesde.ga.aplicacion.models.GroupsSubjects;
import co.edu.cesde.ga.aplicacion.repository.GroupSubjectsRepository;
import co.edu.cesde.ga.aplicacion.service.GroupSubjectsService;
import co.edu.cesde.ga.aplicacion.service.GroupSubjectsService;

import java.util.List;

public class GroupSubjectsServiceImpl implements GroupSubjectsService {

    private final GroupSubjectsRepository groupSubjectRepository;

    // Inyección por constructor para conectar con el repositorio
    public GroupSubjectsServiceImpl(GroupSubjectsRepository groupSubjectRepository) {
        this.groupSubjectRepository = groupSubjectRepository;
    }

    @Override
    public void assignSubjectToGroup(GroupsSubjects groupSubject) {
        // Aquí se guarda la relación entre Grupo, Materia y Docente
        groupSubjectRepository.save(groupSubject);
    }

    @Override
    public GroupsSubjects getAssignmentById(Long id) {
        return groupSubjectRepository.findById(id).orElse(null);
    }

    @Override
    public List<GroupsSubjects> getSubjectsByGroup(Long groupId) {
        return groupSubjectRepository.findByGroupId(groupId);
    }

    @Override
    public List<GroupsSubjects> getAllAssignments() {
        return groupSubjectRepository.findAll();
    }

    @Override
    public void removeAssignment(Long id) {
        groupSubjectRepository.delete(id);
    }
}
