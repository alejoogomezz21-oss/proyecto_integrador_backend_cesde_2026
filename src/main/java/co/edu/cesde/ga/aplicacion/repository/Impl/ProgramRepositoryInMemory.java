package co.edu.cesde.ga.aplicacion.repository.Impl;

import co.edu.cesde.ga.aplicacion.models.Programs;
import co.edu.cesde.ga.aplicacion.repository.ProgramRepository;
import java.util.ArrayList;
import java.util.List;

public class ProgramRepositoryInMemory implements ProgramRepository {
    private static List<Programs> programsList = new ArrayList<>();

    @Override
    public Programs save(Programs program) {
        programsList.add(program);
        return program;
    }

    @Override
    public List<Programs> findAll() {
        return programsList;
    }

    @Override
    public Programs findById(Long id) {
        return programsList.stream()
                .filter(p -> p.getProgramId().equals(id))
                .findFirst()
                .orElse(null);
    }
}