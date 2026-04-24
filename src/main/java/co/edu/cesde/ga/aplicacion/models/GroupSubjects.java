package co.edu.cesde.ga.aplicacion.models;

public class GroupSubjects {
    private Long id;
    private Long groupId;
    private Long subjectId;
    private Long teacherId;

    public GroupSubjects() {}

    public GroupSubjects(Long id, Long groupId, Long subjectId, Long teacherId) {
        this.id = id;
        this.groupId = groupId;
        this.subjectId = subjectId;
        this.teacherId = teacherId;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getGroupId() { return groupId; }
    public void setGroupId(Long groupId) { this.groupId = groupId; }
    public Long getSubjectId() { return subjectId; }
    public void setSubjectId(Long subjectId) { this.subjectId = subjectId; }
    public Long getTeacherId() { return teacherId; }
    public void setTeacherId(Long teacherId) { this.teacherId = teacherId; }
}