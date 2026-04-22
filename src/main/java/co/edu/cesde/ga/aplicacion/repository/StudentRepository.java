package co.edu.cesde.ga.aplicacion.repository;
import co.edu.cesde.ga.aplicacion.models.Students;

import java.awt.*;
import java.util.List;
public interface StudentRepository {

    Students create (Students student);

    boolean delete(Long studentId);

    boolean update(Students studentUpdate);

    Students findById(Long studentId);

    boolean findByDocumentNumber(String documentNumber);

    List<Students> findAll();

    boolean existsById(Long studentId);

    boolean existsByDocumentNumber(String documentNumber);
}

