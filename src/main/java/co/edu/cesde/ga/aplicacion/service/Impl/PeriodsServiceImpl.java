package co.edu.cesde.ga.aplicacion.service.Impl;

import co.edu.cesde.ga.aplicacion.models.Periods;
import co.edu.cesde.ga.aplicacion.repository.PeriodsRepository;
import co.edu.cesde.ga.aplicacion.service.PeriodsService;
import java.util.List;

public class PeriodsServiceImpl implements PeriodsService {

    private final PeriodsRepository periodsRepository;

    // Inyección por constructor para conectar con el Repository
    public PeriodsServiceImpl(PeriodsRepository periodsRepository) {
        this.periodsRepository = periodsRepository;
    }

    @Override
    public void createPeriod(Periods period) {
        // Aquí podrías validar que las fechas no se crucen, por ejemplo
        periodsRepository.save(period);
    }

    @Override
    public Periods getPeriodById(Long id) {
        return periodsRepository.findById(id).orElse(null);
    }

    @Override
    public List<Periods> getAllPeriods() {
        return periodsRepository.findAll();
    }

    @Override
    public void updatePeriod(Periods period) {
        periodsRepository.update(period);
    }

    @Override
    public void deletePeriod(Long id) {
        periodsRepository.delete(id);
    }
}
