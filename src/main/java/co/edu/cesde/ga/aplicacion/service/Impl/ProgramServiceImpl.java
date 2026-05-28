package co.edu.cesde.ga.aplicacion.service.Impl;

import co.edu.cesde.ga.aplicacion.models.Programs;
import co.edu.cesde.ga.aplicacion.repository.ProgramRepository;
import co.edu.cesde.ga.aplicacion.repository.Impl.ProgramRepositoryInMemory;
import co.edu.cesde.ga.aplicacion.service.ProgramService;
import java.util.List;

public class ProgramServiceImpl implements ProgramService {
    private final ProgramRepository programRepository;

    public ProgramServiceImpl() {
        this.programRepository = new ProgramRepositoryInMemory();
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
}