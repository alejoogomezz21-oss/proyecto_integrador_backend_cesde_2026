package co.edu.cesde.ga.aplicacion.repository.Impl;

import co.edu.cesde.ga.aplicacion.models.Subjects;
import co.edu.cesde.ga.aplicacion.repository.SubjectsRepository;

import java.util.ArrayList;
import java.util.List;

public class SubjectsRepositoryInMemory implements SubjectsRepository{


    private List<Subjects> subjectsList = new ArrayList<>();

    @Override
    public Subjects create(Subjects subject) {
        subjectsList.add(subject);
        return subject;
    }

    @Override
    public boolean delete(Long subjectId) {
        return subjectsList.removeIf(subject -> subject.getSubjectId().equals(subjectId));
    }

    @Override
    public boolean update(Subjects subjectUpdate) {
        for (int i = 0; i < subjectsList.size(); i++) {
            if (subjectsList.get(i).getSubjectId().equals(subjectUpdate.getSubjectId())) {
                subjectsList.set(i, subjectUpdate);
                return true;
            }
        }
        return false;
    }

    @Override
    public Subjects findById(Long subjectId) {
        return subjectsList.stream()
                .filter(subject -> subject.getSubjectId().equals(subjectId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Subjects> findAll() {
        return subjectsList;
    }

    @Override
    public boolean existsById(Long subjectId) {
        return subjectsList.stream()
                .anyMatch(subject -> subject.getSubjectId().equals(subjectId));
    }

}
