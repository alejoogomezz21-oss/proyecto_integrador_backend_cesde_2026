package co.edu.cesde.ga.aplicacion.models;

import jakarta.persistence.*;

@Entity
@Table(name = "group_subjects")
public class GroupsSubjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Groups group;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subjects subject;

    public GroupsSubjects() {}

    public GroupsSubjects(Long id, Groups group, Subjects subject) {
        this.id = id;
        this.group = group;
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long Id) {
        this.id = id;
    }

    public Groups getGroup() {
        return group;
    }
    public void setGroup(Groups group) {
        this.group = group;
    }

    public Subjects getSubject() {
        return subject;
    }
    public void setSubject(Subjects subject) {
        this.subject = subject;
    }
}