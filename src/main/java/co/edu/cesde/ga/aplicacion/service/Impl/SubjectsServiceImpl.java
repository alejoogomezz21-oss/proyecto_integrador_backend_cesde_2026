
package co.edu.cesde.ga.aplicacion.service.Impl;

import co.edu.cesde.ga.aplicacion.models.Subjects;
import co.edu.cesde.ga.aplicacion.repository.SubjectsRepository;
import co.edu.cesde.ga.aplicacion.repository.Impl.SubjectsRepositoryInMemory;
import co.edu.cesde.ga.aplicacion.service.SubjectsService;
import java.util.List;

public class SubjectsServiceImpl implements SubjectsService {

    private final SubjectsRepository subjectsRepository;

    public SubjectsServiceImpl() {
        this.subjectsRepository = new SubjectsRepositoryInMemory();
    }

    @Override
    public Subjects create(Subjects subject) {
        return subjectsRepository.create(subject);
    }

    @Override
    public boolean delete(Long subjectId) {
        return subjectsRepository.delete(subjectId);
    }

    @Override
    public boolean update(Subjects subjectUpdate) {
        return subjectsRepository.update(subjectUpdate);
    }

    @Override
    public Subjects findById(Long subjectId) {
        return subjectsRepository.findById(subjectId);
    }

    @Override
    public List<Subjects> findAll() {
        return subjectsRepository.findAll();
    }

    @Override
    public boolean existsById(Long subjectId) {
        return subjectsRepository.existsById(subjectId);
    }
}