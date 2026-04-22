package co.edu.cesde.ga.aplicacion.repository;

import co.edu.cesde.ga.aplicacion.models.Teachers;

import java.util.List;

public interface TeacherRepository {
    Teachers create (Teachers teacher);

    boolean delete(Long teacherId);

    boolean update(Teachers teacherUpdate);

    Teachers findById(Long teacherId);

    List<Teachers> findAll();

    Teachers findByDocumentNumber(String documentNumber);
    boolean existsByDocumentNumber(String documentNumber);

    boolean existsById(Long teacherId);
}

