package co.edu.cesde.ga.aplicacion.repository.Impl;

import co.edu.cesde.ga.aplicacion.models.Enrollments;
import co.edu.cesde.ga.aplicacion.repository.EnrollmentsRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EnrollmentsRepositoryInMemory implements EnrollmentsRepository {
    private List<Enrollments> enrollmentsList = new ArrayList<>();

    @Override
    public void save(Enrollments enrollment) {
        enrollmentsList.add(enrollment);
    }

    @Override
    public Optional<Enrollments> findById(Long enrollmentId) {
        return enrollmentsList.stream()
                .filter(e -> e.getEnrollmentId().equals(enrollmentId))
                .findFirst();
    }

    @Override
    public List<Enrollments> findByStudentId(Long studentId) {
        return enrollmentsList.stream()
                .filter(e -> e.getStudentId().equals(studentId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Enrollments> findAll() {
        return new ArrayList<>(enrollmentsList);
    }

    @Override
    public void delete(Long enrollmentId) {
        enrollmentsList.removeIf(e -> e.getEnrollmentId().equals(enrollmentId));
    }
}
