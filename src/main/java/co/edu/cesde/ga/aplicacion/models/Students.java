package co.edu.cesde.ga.aplicacion.models;
import java.time.LocalDate;

public class Students {
    private Long studentId;
    private Long userId;
    private String code;
    private String documentNumber;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String status;

    public Students() {}
    public Students(Long studentId, Long userId, String code, String documentNumber, String firstName, String lastName, LocalDate birthDate, String status) {
        this.studentId = studentId; this.userId = userId; this.code = code;
        this.documentNumber = documentNumber; this.firstName = firstName;
        this.lastName = lastName; this.birthDate = birthDate; this.status = status;
    }
    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getDocumentNumber() { return documentNumber; }
    public void setDocumentNumber(String documentNumber) { this.documentNumber = documentNumber; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}