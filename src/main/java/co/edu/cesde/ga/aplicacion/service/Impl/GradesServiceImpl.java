package co.edu.cesde.ga.aplicacion.service.Impl;

import co.edu.cesde.ga.aplicacion.service.GradesService;
import co.edu.cesde.ga.aplicacion.models.Grades;
import co.edu.cesde.ga.aplicacion.repository.GradesRepository;

import java.util.List;

public class GradesServiceImpl implements GradesService {

    private final GradesRepository gradesRepository;

    public GradesServiceImpl(GradesRepository gradesRepository) {
        this.gradesRepository = gradesRepository;
    }

    @Override
    public Grades create(Grades grade) {
        if (isInvalidGrade(grade)) {
            return null;
        }
        return gradesRepository.create(grade);
    }

    private boolean isInvalidGrade(Grades grade) {
        return grade == null
                || grade.getGroupSubjectId() == null
                || grade.getStudentId() == null
                || grade.getFinalScore() == null;
    }

    @Override
    public boolean delete(Long gradeId) {
        if (gradeId == null) {
            return false;
        }
        Grades grade = findById(gradeId);
        if (grade == null) {
            return false;
        }
        return gradesRepository.delete(gradeId);
    }

    @Override
    public boolean update(Grades gradeUpdate) {
        if (gradeUpdate == null || isInvalidGrade(gradeUpdate) || gradeUpdate.getGradeId() == null) {
            return false;
        }
        return gradesRepository.update(gradeUpdate);
    }

    @Override
    public Grades findById(Long gradeId) {
        if (gradeId == null || gradeId < 0L) {
            return null;
        }
        return gradesRepository.findById(gradeId);
    }

    @Override
    public List<Grades> findAll() {
        return gradesRepository.findAll();
    }

    @Override
    public boolean existsById(Long gradeId) {
        return gradesRepository.existsById(gradeId);
    }


}
