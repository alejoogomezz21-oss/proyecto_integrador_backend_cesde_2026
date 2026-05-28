package co.edu.cesde.ga.aplicacion.service.Impl;

import co.edu.cesde.ga.aplicacion.models.Periods;
import co.edu.cesde.ga.aplicacion.repository.PeriodsRepository;
import co.edu.cesde.ga.aplicacion.service.PeriodsService;
import java.util.List;

public class PeriodsServiceImpl implements PeriodsService {

    private final PeriodsRepository periodsRepository;


    public PeriodsServiceImpl(PeriodsRepository periodsRepository) {
        this.periodsRepository = periodsRepository;
    }

    @Override
    public void createPeriod(Periods period) {

        if (period.getName() == null || period.getName().trim().isEmpty()) {
            throw new co.edu.cesde.ga.aplicacion.exceptions.ValidacionDatosException("El nombre del periodo es obligatorio.");
        }

        // 2. Validar fechas (que no sean nulas y que el inicio sea antes del fin)
        if (period.getStartDate() == null) {
            throw new co.edu.cesde.ga.aplicacion.exceptions.ValidacionDatosException("La fecha de inicio es obligatoria.");
        }
        if (period.getEndDate() == null) {
            throw new co.edu.cesde.ga.aplicacion.exceptions.ValidacionDatosException("La fecha de fin es obligatoria.");
        }
        if (period.getEndDate().isBefore(period.getStartDate())) {
            throw new co.edu.cesde.ga.aplicacion.exceptions.ValidacionDatosException("La fecha de fin no puede ser anterior a la fecha de inicio.");
        }
        periodsRepository.save(period);
    }

    @Override
    public Periods getPeriodById(Long id) {

        return periodsRepository.findById(id)
                .orElseThrow(() -> new co.edu.cesde.ga.aplicacion.exceptions.ObjetoNoEncontradoException("No se encontró el periodo con ID: " + id));
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
