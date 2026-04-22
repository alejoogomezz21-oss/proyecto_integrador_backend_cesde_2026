package co.edu.cesde.ga.aplicacion.repository.Impl;

import co.edu.cesde.ga.aplicacion.models.Students;
import co.edu.cesde.ga.aplicacion.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryInMemory implements StudentRepository {

    private List<Students> students;
    private Long nextStudentId;

    public StudentRepositoryInMemory() {
        this.students = new ArrayList<>();
        this.nextStudentId = 1L;
    }

    @Override
    public Students create(Students student) {
        if (student == null) {
            return null;
        }
        if (findByDocumentNumber(student.getDocumentNumber())) {
            return null;
        }
        student.setStudentId(nextStudentId++);
        students.add(student);
        return student;
    }

    @Override
    public boolean delete(Long studentId) {
        if (studentId == null) {
            return false;
        }

        Students student = findById(studentId);
        if (student == null) {
            return false;
        }

        return students.remove(student);
    }

    @Override
    public boolean update(Students studentUpdate) {
        if (studentUpdate == null || studentUpdate.getStudentId() == null) {
            return false;
        }
        for (Students student : students) {
            if (!student.getStudentId().equals(studentUpdate.getStudentId()) &&
                    student.getDocumentNumber().equals(studentUpdate.getDocumentNumber())) {
                return false;
            }
        }
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equals(studentUpdate.getStudentId())) {
                students.set(i, studentUpdate);
                return true;
            }
        }
        return false;
    }

    @Override
    public Students findById(Long studentId) {
        if (studentId == null || studentId < 0L){
            return null;
        }
        for (Students student : students){
            if (studentId.equals(student.getStudentId())){
                return student;
            }
        }
        return null;
    }

    @Override
    public boolean findByDocumentNumber(String documentNumber) {
        if (documentNumber == null || documentNumber.isBlank()) {
            return false;
        }
        for (Students student : students) {
            if (student.getDocumentNumber().equals(documentNumber)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Students> findAll() {
        return new ArrayList<>(students);
    }

    @Override
    public boolean existsById(Long studentId) {
        if (studentId == null || studentId <0L){
            return false;
        }
        for (Students student : students){
            if (studentId.equals(student.getStudentId())){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existsByDocumentNumber(String documentNumber) {
        if (documentNumber == null || documentNumber.isBlank()) {
            return false;
        }

        for (Students student : students) {
            if (student.getDocumentNumber().equals(documentNumber)) {
                return true;
            }
        }
        return false;
    }
}