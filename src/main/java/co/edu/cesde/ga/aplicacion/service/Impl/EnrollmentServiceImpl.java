package co.edu.cesde.ga.aplicacion.service.Impl;

import co.edu.cesde.ga.aplicacion.models.Enrollments;
import co.edu.cesde.ga.aplicacion.repository.EnrollmentsRepository;
import co.edu.cesde.ga.aplicacion.service.EnrollmentService;
import java.util.List;

public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentsRepository enrollmentRepository;

    // Inyección por constructor para conectar con el Repository
    public EnrollmentServiceImpl(EnrollmentsRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public void enrollStudent(Enrollments enrollment) {
        // Aquí podrías validar que el estudiante no esté ya matriculado en la misma materia
        enrollmentRepository.save(enrollment);
    }

    @Override
    public Enrollments getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Enrollments> getEnrollmentsByStudent(Long studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    @Override
    public List<Enrollments> getAllEnrollments() {
        return (List) enrollmentRepository.findAll();
    }

    @Override
    public void cancelEnrollment(Long id) {
        enrollmentRepository.delete(id);
    }
}
