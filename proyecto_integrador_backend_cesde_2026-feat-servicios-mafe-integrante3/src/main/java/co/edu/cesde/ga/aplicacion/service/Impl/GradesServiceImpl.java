package co.edu.cesde.ga.aplicacion.service.Impl;

import co.edu.cesde.ga.aplicacion.exceptions.ObjetoNoEncontradoException;
import co.edu.cesde.ga.aplicacion.exceptions.ValidacionDatosException;
import co.edu.cesde.ga.aplicacion.service.GradesService;
import co.edu.cesde.ga.aplicacion.models.Grades;
import co.edu.cesde.ga.aplicacion.repository.GradesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradesServiceImpl implements GradesService {

    private final GradesRepository gradesRepository;

    @Autowired
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


        return gradesRepository.save(grade);
    }

    @Override
    public boolean delete(Long gradeId) {
        if (gradeId == null) {
            throw new ValidacionDatosException("El ID de la nota es obligatorio.");
        }
        // Validamos que exista antes de borrar; si no, lanza excepción
        findById(gradeId);

        gradesRepository.deleteById(gradeId);
        return true;
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

        // Verificamos que exista antes de actualizar
        if (!gradesRepository.existsById(gradeUpdate.getGradeId())) {
            throw new ObjetoNoEncontradoException("No se encontró una nota con el ID: " + gradeUpdate.getGradeId());
        }

        gradesRepository.save(gradeUpdate);
        return true;
    }

    @Override
    public Grades findById(Long gradeId) {
        if (gradeId == null) {
            throw new ValidacionDatosException("El ID de la nota es obligatorio.");
        }

        return gradesRepository.findById(gradeId)
                .orElseThrow(() -> new ObjetoNoEncontradoException("No se encontró una nota con el ID: " + gradeId));
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