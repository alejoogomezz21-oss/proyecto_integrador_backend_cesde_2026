package co.edu.cesde.ga.aplicacion.service.Impl;
import co.edu.cesde.ga.aplicacion.models.Teachers;
import co.edu.cesde.ga.aplicacion.repository.TeacherRepository;
import co.edu.cesde.ga.aplicacion.service.TeacherService;
import java.util.List;

public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;


    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teachers create(Teachers teacher) {

        if (isInvalidTeacher(teacher) || teacherRepository.existsByDocumentNumber(teacher.getDocumentNumber())) {
            return null;
        }
        return teacherRepository.create(teacher);
    }

    @Override
    public boolean delete(Long teacherId) {
        if (teacherId == null || teacherId < 0L) {
            return false;
        }

        if (teacherRepository.findById(teacherId) == null) {
            return false;
        }
        return teacherRepository.delete(teacherId);
    }

    @Override
    public boolean update(Teachers teacherUpdate) {
        if (teacherUpdate == null || isInvalidTeacher(teacherUpdate) || teacherUpdate.getTeacherId() == null) {
            return false;
        }
        return teacherRepository.update(teacherUpdate);
    }

    @Override
    public Teachers findById(Long teacherId) {
        if (teacherId == null || teacherId < 0L) {
            return null;
        }
        return teacherRepository.findById(teacherId);
    }

    @Override
    public List<Teachers> findAll() {
        return teacherRepository.findAll();
    }

    private boolean isInvalidTeacher(Teachers teacher) {
        return teacher == null
                || !isNotBlank(teacher.getDocumentNumber())
                || !isNotBlank(teacher.getFirstName())
                || !isNotBlank(teacher.getLastName());
    }

    private boolean isNotBlank(String value) {
        return value != null && !value.isBlank();
    }
}