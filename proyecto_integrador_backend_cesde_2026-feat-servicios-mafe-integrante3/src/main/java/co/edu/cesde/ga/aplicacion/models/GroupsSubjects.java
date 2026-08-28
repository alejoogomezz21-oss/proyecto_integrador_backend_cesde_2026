package co.edu.cesde.ga.aplicacion.models;

import jakarta.persistence.*;

@Entity
@Table(name = "group_subjects")
public class GroupsSubjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupSubjectId;

    @Column(name = "group_id", nullable = false)
    private Long groupId;

    @Column(name = "subject_id", nullable = false)
    private Long subjectId;

    public GroupsSubjects() {}

    public GroupsSubjects(Long groupSubjectId, Long groupId, Long subjectId) {
        this.groupSubjectId = groupSubjectId;
        this.groupId = groupId;
        this.subjectId = subjectId;
    }

    public Long getGroupSubjectId() {
        return groupSubjectId;
    }
    public void setGroupSubjectId(Long groupSubjectId) {
        this.groupSubjectId = groupSubjectId;
    }

    public Long getGroupId() {
        return groupId;
    }
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getSubjectId() {
        return subjectId;
    }
    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }
}