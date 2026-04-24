package co.edu.cesde.ga.aplicacion.models;

import java.time.LocalDate;

public class Enrollments { // Asegúrate que sea plural
    private Long enrollmentId;
    private Long studentId;
    private Long subjectId;
    private Long periodId;
    private LocalDate enrollmentDate;
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

    // Getters indispensables para que el Impl no saque error
    public Long getEnrollmentId() { return enrollmentId; }
    public Long getStudentId() { return studentId; }
}