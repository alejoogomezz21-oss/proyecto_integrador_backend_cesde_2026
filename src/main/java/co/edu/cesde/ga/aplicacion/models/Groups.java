package co.edu.cesde.ga.aplicacion.models;

import jakarta.persistence.*;

@Entity
@Table(name = "groups")
public class Groups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;

    @Column(nullable = false, unique = true, length = 50)
    private String code;

    @Column(name = "program_id", nullable = false)
    private Long programId;

    @Column(name = "period_id", nullable = false)
    private Long periodId;

    @Column(length = 50)
    private String shift;

    public Groups() {}

    public Groups(Long groupId, String code, Long programId, Long periodId, String shift) {
        this.groupId = groupId;
        this.code = code;
        this.programId = programId;
        this.periodId = periodId;
        this.shift = shift;
    }

    // Getters y Setters
    public Long getGroupId() {
        return groupId;
    }
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public Long getProgramId() {
        return programId;
    }
    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public Long getPeriodId() {
        return periodId;
    }
    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public String getShift() {
        return shift;
    }
    public void setShift(String shift) {
        this.shift = shift;
    }
}