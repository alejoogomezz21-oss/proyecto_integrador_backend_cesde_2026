package co.edu.cesde.ga.aplicacion.repository;

import co.edu.cesde.ga.aplicacion.models.Subjects;
import java.util.List;

public interface SubjectsRepository {

    Subjects create(Subjects subjects);

    boolean delete(Long subjectsId);

    boolean update(Subjects subjectsUpdate);

    Subjects findById(Long subjectsId);

    List<Subjects> findAll();

    boolean existsById(Long subjectsId);

}
