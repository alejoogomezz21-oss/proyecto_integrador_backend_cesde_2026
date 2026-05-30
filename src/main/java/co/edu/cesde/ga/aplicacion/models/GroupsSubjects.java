package co.edu.cesde.ga.aplicacion.models;

public class GroupsSubjects {
    private Long groupSubjectId;
    private Long groupId;
    private Long subjectId;

    public GroupsSubjects() {}

    public GroupsSubjects(Long groupSubjectId, Long groupId, Long subjectId) {
        this.groupSubjectId = groupSubjectId;
        this.groupId = groupId;
        this.subjectId = subjectId;
    }

    public Long getGroupSubjectId() { return groupSubjectId; }
    public void setGroupSubjectId(Long groupSubjectId) { this.groupSubjectId = groupSubjectId; }
    public Long getGroupId() { return groupId; }
    public void setGroupId(Long groupId) { this.groupId = groupId; }
    public Long getSubjectId() { return subjectId; }
    public void setSubjectId(Long subjectId) { this.subjectId = subjectId; }
}