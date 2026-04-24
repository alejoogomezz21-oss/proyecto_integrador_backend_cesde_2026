package co.edu.cesde.ga.aplicacion.models;

public class Roles {
    private Long roleId;
    private String name;
    private String description;

    public Roles() {}

    public Roles(Long roleId, String name, String description) {
        this.roleId = roleId;
        this.name = name;
        this.description = description;
    }

    // Getters y Setters (Indispensables para que el repositorio no saque error)
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}