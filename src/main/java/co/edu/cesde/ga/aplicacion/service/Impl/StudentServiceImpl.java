package co.edu.cesde.ga.aplicacion.service.Impl;
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
        if (isInvalidStudent(student) || studentRepository.existsByDocumentNumber(student.getDocumentNumber())) {
            return null;
        }
        return studentRepository.create(student);
    }

    private boolean isInvalidStudent(Students student) {
        return student == null
                || !isNotBlank(student.getCode())
                || !isNotBlank(student.getDocumentNumber())
                || !isNotBlank(student.getFirstName())
                || !isNotBlank(student.getLastName())
                || student.getStatus() == null
                || student.getBirthDate() == null;
    }

    private boolean isNotBlank(String value) {
        return value != null && !value.isBlank();
    }

    @Override
    public boolean delete(Long studentId) {
        if (studentId == null) {
            return false;
        }

        Students student = findById(studentId);
        if (student == null) {
            return false;
        }

        return studentRepository.delete(studentId);
    }

    @Override
    public boolean update(Students studentUpdate) {

        if (studentUpdate == null || isInvalidStudent(studentUpdate) || studentUpdate.getStudentId() == null) {
            return false;
        }
        return studentRepository.update(studentUpdate);
    }

    @Override
    public Students findById(Long studentId) {

        if (studentId == null || studentId < 0L) {
            return null;
        }

        return studentRepository.findById(studentId);
    }

    @Override
    public List<Students> findAll() {
        return studentRepository.findAll();
    }
}