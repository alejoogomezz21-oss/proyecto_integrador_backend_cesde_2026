package co.edu.cesde.ga.aplicacion.repository;

import co.edu.cesde.ga.aplicacion.models.Enrollments;
import java.util.List;
import java.util.Optional;



public interface EnrollmentsRepository {


    void save(Enrollments enrollment);


    Optional<Enrollments> findById(Long enrollmentId);


    List<Enrollments> findByStudentId(Long studentId);


    List<Enrollments> findAll();


    void delete(Long enrollmentId);
}
