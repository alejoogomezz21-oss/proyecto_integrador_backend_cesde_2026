package co.edu.cesde.ga.aplicacion.service.Impl;

import co.edu.cesde.ga.aplicacion.exceptions.ObjetoNoEncontradoException;
import co.edu.cesde.ga.aplicacion.exceptions.ValidacionDatosException;
import co.edu.cesde.ga.aplicacion.models.Students;
import co.edu.cesde.ga.aplicacion.repository.StudentRepository;
import co.edu.cesde.ga.aplicacion.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Students create(Students student) {
        if (student == null) {
            throw new ValidacionDatosException("El estudiante no puede ser nulo.");
        }
        if (student.getCode() == null || student.getCode().trim().isEmpty()) {
            throw new ValidacionDatosException("El código del estudiante es obligatorio.");
        }
        if (student.getDocumentNumber() == null || student.getDocumentNumber().trim().isEmpty()) {
            throw new ValidacionDatosException("El número de documento es obligatorio.");
        }
        if (student.getFirstName() == null || student.getFirstName().trim().isEmpty()) {
            throw new ValidacionDatosException("El nombre del estudiante es obligatorio.");
        }
        if (student.getLastName() == null || student.getLastName().trim().isEmpty()) {
            throw new ValidacionDatosException("El apellido del estudiante es obligatorio.");
        }
        if (student.getBirthDate() == null) {
            throw new ValidacionDatosException("La fecha de nacimiento es obligatoria.");
        }
        if (student.getStatus() == null || student.getStatus().trim().isEmpty()) {
            throw new ValidacionDatosException("El estado del estudiante es obligatorio.");
        }

        return studentRepository.create(student);
    }

    @Override
    public boolean delete(Long studentId) {
        if (studentId == null) {
            throw new ValidacionDatosException("El ID del estudiante es obligatorio.");
        }
        findById(studentId);

        return studentRepository.delete(studentId);
    }

    @Override
    public boolean update(Students studentUpdate) {
        if (studentUpdate == null) {
            throw new ValidacionDatosException("El estudiante no puede ser nulo.");
        }
        if (studentUpdate.getStudentId() == null) {
            throw new ValidacionDatosException("El ID del estudiante es obligatorio para actualizar.");
        }
        if (studentUpdate.getFirstName() == null || studentUpdate.getFirstName().trim().isEmpty()) {
            throw new ValidacionDatosException("El nombre del estudiante es obligatorio.");
        }
        if (studentUpdate.getLastName() == null || studentUpdate.getLastName().trim().isEmpty()) {
            throw new ValidacionDatosException("El apellido del estudiante es obligatorio.");
        }

        return studentRepository.update(studentUpdate);
    }

    @Override
    public Students findById(Long studentId) {
        if (studentId == null) {
            throw new ValidacionDatosException("El ID del estudiante es obligatorio.");
        }

        Students student = studentRepository.findById(studentId);
        if (student == null) {
            throw new ObjetoNoEncontradoException("No se encontró un estudiante con el ID: " + studentId);
        }

        return student;
    }

    @Override
    public List<Students> findAll() {
        return studentRepository.findAll();
    }
}