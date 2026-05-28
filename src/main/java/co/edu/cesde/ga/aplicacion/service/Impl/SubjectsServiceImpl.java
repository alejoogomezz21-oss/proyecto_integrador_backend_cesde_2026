
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

        if (subject.getName() == null || subject.getName().trim().isEmpty()) {
            throw new co.edu.cesde.ga.aplicacion.exceptions.ValidacionDatosException("El nombre de la materia es obligatorio.");
        }

        if (subject.getCredits() == null || subject.getCredits() <= 0) {
            throw new co.edu.cesde.ga.aplicacion.exceptions.ValidacionDatosException("La materia debe tener al menos 1 crédito.");
        }

        if (subject.getCode() == null || subject.getCode().trim().isEmpty()) {
            throw new co.edu.cesde.ga.aplicacion.exceptions.ValidacionDatosException("El código de la materia es obligatorio.");
        }

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

        Subjects subject = subjectsRepository.findById(subjectId);
        if (subject == null) {
            throw new co.edu.cesde.ga.aplicacion.exceptions.ObjetoNoEncontradoException("No se encontró la materia con ID: " + subjectId);
        }
        return subject;
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