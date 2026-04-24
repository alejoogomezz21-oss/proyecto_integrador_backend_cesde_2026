package co.edu.cesde.ga.aplicacion.repository.Impl;

import co.edu.cesde.ga.aplicacion.models.Periods;
import co.edu.cesde.ga.aplicacion.repository.PeriodsRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PeriodsRepositoryInMemory implements PeriodsRepository {

    // Lista en memoria para simular la base de datos
    private List<Periods> periodsList = new ArrayList<>();

    @Override
    public void save(Periods period) {
        periodsList.add(period);
    }

    @Override
    public Optional<Periods> findById(Long periodId) {
        return periodsList.stream()
                .filter(p -> p.getPeriodId().equals(periodId))
                .findFirst();
    }

    @Override
    public List<Periods> findAll() {
        return new ArrayList<>(periodsList);
    }

    @Override
    public void update(Periods period) {
        findById(period.getPeriodId()).ifPresent(existingPeriod -> {
            int index = periodsList.indexOf(existingPeriod);
            periodsList.set(index, period);
        });
    }

    @Override
    public void delete(Long periodId) {
        periodsList.removeIf(p -> p.getPeriodId().equals(periodId));
    }
}
