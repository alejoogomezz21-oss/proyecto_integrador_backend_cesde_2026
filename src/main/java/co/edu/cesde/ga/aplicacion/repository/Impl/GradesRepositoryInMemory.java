package co.edu.cesde.ga.aplicacion.repository.Impl;

import co.edu.cesde.ga.aplicacion.models.Grades;
import co.edu.cesde.ga.aplicacion.repository.GradesRepository;

import java.util.ArrayList;
import java.util.List;

public class GradesRepositoryInMemory implements GradesRepository {

    private List<Grades> gradesList = new ArrayList<>();

    @Override
    public Grades create(Grades grade) {
        gradesList.add(grade);
        return grade;
    }

    @Override
    public boolean delete(Long gradeId) {
        return gradesList.removeIf(grade -> grade.getGradeId().equals(gradeId));
    }

    @Override
    public boolean update(Grades gradeUpdate) {
        for (int i = 0; i < gradesList.size(); i++) {
            if (gradesList.get(i).getGradeId().equals(gradeUpdate.getGradeId())) {
                gradesList.set(i, gradeUpdate);
                return true;
            }
        }
        return false;
    }

    @Override
    public Grades findById(Long gradeId) {
        return gradesList.stream()
                .filter(grade -> grade.getGradeId().equals(gradeId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Grades> findAll() {
        return gradesList;
    }

    @Override
    public boolean existsById(Long gradeId) {
        return gradesList.stream()
                .anyMatch(grade -> grade.getGradeId().equals(gradeId));
    }

}
