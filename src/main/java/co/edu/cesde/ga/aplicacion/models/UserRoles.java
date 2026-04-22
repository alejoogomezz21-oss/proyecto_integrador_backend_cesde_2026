package co.edu.cesde.ga.aplicacion.models;

public class UserRoles {
    private Long userId; // user_id
    private Long roleId; // role_id

    public UserRoles() {}

    public UserRoles(Long userId, Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getRoleId() { return roleId; }
    public void setRoleId(Long roleId) { this.roleId = roleId; }
}
