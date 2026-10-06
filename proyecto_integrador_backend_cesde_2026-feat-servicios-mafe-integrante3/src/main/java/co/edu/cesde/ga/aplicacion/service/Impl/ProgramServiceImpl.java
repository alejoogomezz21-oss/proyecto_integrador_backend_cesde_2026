package co.edu.cesde.ga.aplicacion.service.Impl;

import co.edu.cesde.ga.aplicacion.models.Programs;
import co.edu.cesde.ga.aplicacion.repository.ProgramRepository;
import co.edu.cesde.ga.aplicacion.service.ProgramService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramServiceImpl implements ProgramService {
    private final ProgramRepository programRepository;

    public ProgramServiceImpl(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    @Override
    public Programs createProgram(Programs program) {

        if (program.getName() == null || program.getName().trim().isEmpty()) {
            throw new co.edu.cesde.ga.aplicacion.exceptions.ValidacionDatosException("El nombre del programa es obligatorio.");
        }

        if (program.getCode() == null || program.getCode().trim().isEmpty()) {
            throw new co.edu.cesde.ga.aplicacion.exceptions.ValidacionDatosException("El código del programa es obligatorio.");
        }

        return programRepository.save(program);
    }

    @Override
    public List<Programs> getAllPrograms() {
        return programRepository.findAll();
    }

    @Override
    public Programs findById(Long id) {
        return programRepository.findById(id).orElse(null);
    }

    @Override
    public boolean update(Programs program) {
        if (programRepository.existsById(program.getId())) {
            programRepository.save(program);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (programRepository.existsById(id)) {
            programRepository.deleteById(id);
            return true;
        }
        return false;
    }
}