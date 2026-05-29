package co.edu.cesde.ga.aplicacion.models;

public class Enrollments {
    private Long enrollmentId;
    private Long userId; // ID del estudiante
    private Long groupId;
    private String enrollmentDate; // Puedes usar String o LocalDate según manejen las fechas

    public Enrollments() {}

    public Enrollments(Long enrollmentId, Long userId, Long groupId, String enrollmentDate) {
        this.enrollmentId = enrollmentId;
        this.userId = userId;
        this.groupId = groupId;
        this.enrollmentDate = enrollmentDate;
    }

    public Long getEnrollmentId() { return enrollmentId; }
    public void setEnrollmentId(Long enrollmentId) { this.enrollmentId = enrollmentId; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Long getGroupId() { return groupId; }
    public void setGroupId(Long groupId) { this.groupId = groupId; }
    public String getEnrollmentDate() { return enrollmentDate; }
    public void setEnrollmentDate(String enrollmentDate) { this.enrollmentDate = enrollmentDate; }
}
