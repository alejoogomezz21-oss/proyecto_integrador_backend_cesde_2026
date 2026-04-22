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
        // Aquí podrías validar que el código no esté vacío antes de guardar
        return programRepository.save(program);
    }

    @Override
    public List<Programs> getAllPrograms() {
        return programRepository.findAll();
    }
}