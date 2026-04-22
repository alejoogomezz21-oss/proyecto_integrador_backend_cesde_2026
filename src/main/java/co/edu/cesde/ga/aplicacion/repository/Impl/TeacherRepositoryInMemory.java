package co.edu.cesde.ga.aplicacion.repository.Impl;

import co.edu.cesde.ga.aplicacion.models.Teachers;
import co.edu.cesde.ga.aplicacion.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

public class TeacherRepositoryInMemory implements TeacherRepository {

    private List<Teachers> teachers;
    private Long nextTeacherId;

    public TeacherRepositoryInMemory() {
        this.teachers = new ArrayList<>();
        this.nextTeacherId = 1L;
    }

    @Override
    public Teachers create(Teachers teacher) {
        if (teacher == null) {
            return null;
        }

        if (existsByDocumentNumber(teacher.getDocumentNumber())) {
            return null;
        }
        teacher.setTeacherId(nextTeacherId++);
        teachers.add(teacher);
        return teacher;
    }

    @Override
    public boolean delete(Long teacherId) {
        if (teacherId == null) {
            return false;
        }

        Teachers teacher = findById(teacherId);
        if (teacher == null) {
            return false;
        }

        return teachers.remove(teacher);
    }

    @Override
    public boolean update(Teachers teacherUpdate) {
        if (teacherUpdate == null || teacherUpdate.getTeacherId() == null) {
            return false;
        }

        for (Teachers teacher : teachers) {
            if (!teacher.getTeacherId().equals(teacherUpdate.getTeacherId()) &&
                    teacher.getDocumentNumber().equals(teacherUpdate.getDocumentNumber())) {
                return false;
            }
        }
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getTeacherId().equals(teacherUpdate.getTeacherId())) {
                teachers.set(i, teacherUpdate);
                return true;
            }
        }
        return false;
    }

    @Override
    public Teachers findById(Long teacherId) {
        if (teacherId == null || teacherId < 0L){
            return null;
        }
        for (Teachers teacher : teachers){
            if (teacherId.equals(teacher.getTeacherId())){
                return teacher;
            }
        }
        return null;
    }

    @Override
    public Teachers findByDocumentNumber(String documentNumber) {
        if (documentNumber == null || documentNumber.isBlank()) {
            return null;
        }
        for (Teachers teacher : teachers) {
            if (teacher.getDocumentNumber().equals(documentNumber)) {
                return teacher;
            }
        }
        return null;
    }

    @Override
    public boolean existsByDocumentNumber(String documentNumber) {
        return findByDocumentNumber(documentNumber) != null;
    }

    @Override
    public List<Teachers> findAll() {
        return new ArrayList<>(teachers);
    }

    @Override
    public boolean existsById(Long teacherId) {
        if (teacherId == null || teacherId < 0L){
            return false;
        }
        for (Teachers teacher : teachers){
            if (teacherId.equals(teacher.getTeacherId())){
                return true;
            }
        }
        return false;
    }
}