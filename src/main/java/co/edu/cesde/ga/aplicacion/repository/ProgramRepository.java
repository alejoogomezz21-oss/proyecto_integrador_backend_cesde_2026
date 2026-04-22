package co.edu.cesde.ga.aplicacion.repository;

import co.edu.cesde.ga.aplicacion.models.Programs;
import java.util.List;

public interface ProgramRepository {
    Programs save(Programs program);
    List<Programs> findAll();
    Programs findById(Long id);
}