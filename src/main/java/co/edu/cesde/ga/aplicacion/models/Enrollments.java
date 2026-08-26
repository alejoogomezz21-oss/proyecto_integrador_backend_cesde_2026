package co.edu.cesde.ga.aplicacion.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "enrollments")
public class Enrollments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollmentId;

    @Column(name = "student_id", nullable = false)
    private Long studentId;

    @Column(name = "subject_id", nullable = false)
    private Long subjectId;

    @Column(name = "period_id", nullable = false)
    private Long periodId;

    @Column(name = "enrollment_date")
    private LocalDate enrollmentDate;

    @Column(length = 50)
    private String status;

    public Enrollments() {}

    public Enrollments(Long enrollmentId, Long studentId, Long subjectId, Long periodId, LocalDate enrollmentDate, String status) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.periodId = periodId;
        this.enrollmentDate = enrollmentDate;
        this.status = status;
    }

    // Getters y Setters
    public Long getEnrollmentId() {
        return enrollmentId;
    }
    public void setEnrollmentId(Long enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Long getStudentId() {
        return studentId;
    }
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getSubjectId() {
        return subjectId;
    }
    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getPeriodId() {
        return periodId;
    }
    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }
    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}