package co.edu.cesde.ga.aplicacion.service.Impl;

import co.edu.cesde.ga.aplicacion.exceptions.ObjetoNoEncontradoException;
import co.edu.cesde.ga.aplicacion.exceptions.ValidacionDatosException;
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
        if (grade == null) {
            throw new ValidacionDatosException("La nota no puede ser nula.");
        }
        if (grade.getGroupSubjectId() == null) {
            throw new ValidacionDatosException("El ID de la materia del grupo es obligatorio.");
        }
        if (grade.getStudentId() == null) {
            throw new ValidacionDatosException("El ID del estudiante es obligatorio.");
        }
        if (grade.getFinalScore() == null) {
            throw new ValidacionDatosException("La nota final es obligatoria.");
        }

        return gradesRepository.create(grade);
    }

    @Override
    public boolean delete(Long gradeId) {
        if (gradeId == null) {
            throw new ValidacionDatosException("El ID de la nota es obligatorio.");
        }
        findById(gradeId);

        return gradesRepository.delete(gradeId);
    }

    @Override
    public boolean update(Grades gradeUpdate) {
        if (gradeUpdate == null) {
            throw new ValidacionDatosException("La nota no puede ser nula.");
        }
        if (gradeUpdate.getGradeId() == null) {
            throw new ValidacionDatosException("El ID de la nota es obligatorio para actualizar.");
        }
        if (gradeUpdate.getFinalScore() == null) {
            throw new ValidacionDatosException("La nota final es obligatoria.");
        }

        return gradesRepository.update(gradeUpdate);
    }

    @Override
    public Grades findById(Long gradeId) {
        if (gradeId == null) {
            throw new ValidacionDatosException("El ID de la nota es obligatorio.");
        }

        Grades grade = gradesRepository.findById(gradeId);
        if (grade == null) {
            throw new ObjetoNoEncontradoException("No se encontró una nota con el ID: " + gradeId);
        }

        return grade;
    }

    @Override
    public List<Grades> findAll() {
        return gradesRepository.findAll();
    }

    @Override
    public boolean existsById(Long gradeId) {
        if (gradeId == null) {
            throw new ValidacionDatosException("El ID de la nota es obligatorio.");
        }
        return gradesRepository.existsById(gradeId);
    }
}
