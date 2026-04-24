package co.edu.cesde.ga.aplicacion.repository;

import co.edu.cesde.ga.aplicacion.models.Periods;
import java.util.List;
import java.util.Optional;


public interface PeriodsRepository {


    void save(Periods period);


    Optional<Periods> findById(Long periodId);


    List<Periods> findAll();


    void update(Periods period);


    void delete(Long periodId);
}
