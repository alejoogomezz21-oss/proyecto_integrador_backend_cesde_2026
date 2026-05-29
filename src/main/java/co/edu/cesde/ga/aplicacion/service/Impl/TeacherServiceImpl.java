package co.edu.cesde.ga.aplicacion.service.Impl;

import co.edu.cesde.ga.aplicacion.exceptions.ObjetoNoEncontradoException;
import co.edu.cesde.ga.aplicacion.exceptions.ValidacionDatosException;
import co.edu.cesde.ga.aplicacion.models.Teachers;
import co.edu.cesde.ga.aplicacion.repository.TeacherRepository;
import co.edu.cesde.ga.aplicacion.service.TeacherService;
import java.util.List;

public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teachers create(Teachers teacher) {
        if (teacher == null) {
            throw new ValidacionDatosException("El profesor no puede ser nulo.");
        }
        if (teacher.getCode() == null || teacher.getCode().trim().isEmpty()) {
            throw new ValidacionDatosException("El código del profesor es obligatorio.");
        }
        if (teacher.getDocumentNumber() == null || teacher.getDocumentNumber().trim().isEmpty()) {
            throw new ValidacionDatosException("El número de documento es obligatorio.");
        }
        if (teacher.getFirstName() == null || teacher.getFirstName().trim().isEmpty()) {
            throw new ValidacionDatosException("El nombre del profesor es obligatorio.");
        }
        if (teacher.getLastName() == null || teacher.getLastName().trim().isEmpty()) {
            throw new ValidacionDatosException("El apellido del profesor es obligatorio.");
        }
        if (teacher.getStatus() == null || teacher.getStatus().trim().isEmpty()) {
            throw new ValidacionDatosException("El estado del profesor es obligatorio.");
        }

        return teacherRepository.create(teacher);
    }

    @Override
    public boolean delete(Long teacherId) {
        if (teacherId == null) {
            throw new ValidacionDatosException("El ID del profesor es obligatorio.");
        }
        findById(teacherId);

        return teacherRepository.delete(teacherId);
    }

    @Override
    public boolean update(Teachers teacherUpdate) {
        if (teacherUpdate == null) {
            throw new ValidacionDatosException("El profesor no puede ser nulo.");
        }
        if (teacherUpdate.getTeacherId() == null) {
            throw new ValidacionDatosException("El ID del profesor es obligatorio para actualizar.");
        }
        if (teacherUpdate.getFirstName() == null || teacherUpdate.getFirstName().trim().isEmpty()) {
            throw new ValidacionDatosException("El nombre del profesor es obligatorio.");
        }
        if (teacherUpdate.getLastName() == null || teacherUpdate.getLastName().trim().isEmpty()) {
            throw new ValidacionDatosException("El apellido del profesor es obligatorio.");
        }

        return teacherRepository.update(teacherUpdate);
    }

    @Override
    public Teachers findById(Long teacherId) {
        if (teacherId == null) {
            throw new ValidacionDatosException("El ID del profesor es obligatorio.");
        }

        Teachers teacher = teacherRepository.findById(teacherId);
        if (teacher == null) {
            throw new ObjetoNoEncontradoException("No se encontró un profesor con el ID: " + teacherId);
        }

        return teacher;
    }

    @Override
    public List<Teachers> findAll() {
        return teacherRepository.findAll();
    }
}