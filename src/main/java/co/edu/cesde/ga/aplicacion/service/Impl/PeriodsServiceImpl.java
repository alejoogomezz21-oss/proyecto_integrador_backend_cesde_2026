package co.edu.cesde.ga.aplicacion.service.Impl;

import co.edu.cesde.ga.aplicacion.exceptions.ObjetoNoEncontradoException;
import co.edu.cesde.ga.aplicacion.exceptions.ValidacionDatosException;
import co.edu.cesde.ga.aplicacion.models.Periods;
import co.edu.cesde.ga.aplicacion.repository.PeriodsRepository;
import co.edu.cesde.ga.aplicacion.service.PeriodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodsServiceImpl implements PeriodsService {

    private final PeriodsRepository periodsRepository;

    @Autowired
    public PeriodsServiceImpl(PeriodsRepository periodsRepository) {
        this.periodsRepository = periodsRepository;
    }

    @Override
    public void createPeriod(Periods period) {
        if (period.getName() == null || period.getName().trim().isEmpty()) {
            throw new ValidacionDatosException("El nombre del periodo es obligatorio.");
        }
        if (period.getStartDate() == null) {
            throw new ValidacionDatosException("La fecha de inicio es obligatoria.");
        }
        if (period.getEndDate() == null) {
            throw new ValidacionDatosException("La fecha de fin es obligatoria.");
        }
        if (period.getEndDate().isBefore(period.getStartDate())) {
            throw new ValidacionDatosException("La fecha de fin debe ser posterior a la de inicio.");
        }

        periodsRepository.save(period);
    }

    @Override
    public Periods getPeriodById(Long id) {
        return periodsRepository.findById(id)
                .orElseThrow(() -> new ObjetoNoEncontradoException("No se encontró el periodo con el ID proporcionado."));
    }

    @Override
    public List<Periods> getAllPeriods() {
        return periodsRepository.findAll();
    }

    @Override
    public void updatePeriod(Periods period) {
        periodsRepository.save(period);
    }

    @Override
    public void deletePeriod(Long id) {
        periodsRepository.deleteById(id);
    }
}