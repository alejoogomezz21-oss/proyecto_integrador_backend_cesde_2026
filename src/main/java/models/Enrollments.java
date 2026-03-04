package models;
import java.time.LocalDateTime;

public class Enrollments {
    private Long enrollmentId;
    private Long studentId;
    private Long groupId;
    private Long periodId;
    private String status;
    private LocalDateTime enrolledAt;

    public Enrollments() {}
    public Enrollments(Long enrollmentId, Long studentId, Long groupId, Long periodId, String status, LocalDateTime enrolledAt) {
        this.enrollmentId = enrollmentId; this.studentId = studentId;
        this.groupId = groupId; this.periodId = periodId;
        this.status = status; this.enrolledAt = enrolledAt;
    }
    public Long getEnrollmentId() { return enrollmentId; }
    public void setEnrollmentId(Long enrollmentId) { this.enrollmentId = enrollmentId; }
    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }
    public Long getGroupId() { return groupId; }
    public void setGroupId(Long groupId) { this.groupId = groupId; }
    public Long getPeriodId() { return periodId; }
    public void setPeriodId(Long periodId) { this.periodId = periodId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getEnrolledAt() { return enrolledAt; }
    public void setEnrolledAt(LocalDateTime enrolledAt) { this.enrolledAt = enrolledAt; }
}