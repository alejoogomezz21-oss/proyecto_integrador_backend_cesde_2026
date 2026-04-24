package co.edu.cesde.ga.aplicacion.service;

import co.edu.cesde.ga.aplicacion.models.GroupSubjects;
import java.util.List;


public interface GroupSubjectsService {


    void assignSubjectToGroup(GroupSubjects groupSubject);

    GroupSubjects getAssignmentById(Long id);


    List<GroupSubjects> getSubjectsByGroup(Long groupId);


    List<GroupSubjects> getAllAssignments();


    void removeAssignment(Long id);
}