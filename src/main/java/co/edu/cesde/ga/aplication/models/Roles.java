package co.edu.cesde.ga.aplication.models;

public class Roles {
    private Long roleId; // role_id
    private String name; // name
    private String description; // description

    public Roles() {}

    public Roles(Long roleId, String name, String description) {
        this.roleId = roleId;
        this.name = name;
        this.description = description;
    }

    public Long getRoleId() { return roleId; }
    public void setRoleId(Long roleId) { this.roleId = roleId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
