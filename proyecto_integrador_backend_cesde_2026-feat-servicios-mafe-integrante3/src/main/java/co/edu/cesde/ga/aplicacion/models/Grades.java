package co.edu.cesde.ga.aplicacion.models;

import jakarta.persistence.*;

@Entity
@Table(name = "grades")
public class Grades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "group_subject_id", nullable = false)
    private GroupsSubjects groupSubject;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Students student;

    @Column(name = "final_score")
    private Double finalScore;

    @Column(length = 255)
    private String observation;

    public Grades() {}

    public Grades(Long id, GroupsSubjects groupSubject, Students student, Double finalScore, String observation) {
        this.id = id;
        this.groupSubject = groupSubject;
        this.student = student;
        this.finalScore = finalScore;
        this.observation = observation;
    }

    @Transient // Esto le dice a JPA que no busque estas columnas en la base de datos
    private Long groupSubjectId;

    @Transient
    private Long studentId;

    public Long getGroupSubjectId() { return groupSubjectId; }
    public void setGroupSubjectId(Long groupSubjectId) { this.groupSubjectId = groupSubjectId; }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public GroupsSubjects getGroupSubject() {
        return groupSubject;
    }
    public void setGroupSubject(GroupsSubjects groupSubject) {
        this.groupSubject = groupSubject;
    }

    public Students getStudent() {
        return student;
    }
    public void setStudent(Students student) {
        this.student = student;
    }

    public Double getFinalScore() {
        return finalScore;
    }
    public void setFinalScore(Double finalScore) {
        this.finalScore = finalScore;
    }

    public String getObservation() {
        return observation;
    }
    public void setObservation(String observation) {
        this.observation = observation;
    }
}