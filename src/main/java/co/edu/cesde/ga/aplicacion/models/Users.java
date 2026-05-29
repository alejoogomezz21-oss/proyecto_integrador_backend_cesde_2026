package co.edu.cesde.ga.aplicacion.models;

public class Users {
    private Long userId;
    private String identification;
    private String name;
    private String lastName;
    private String email;
    private String password;

    public Users() {}

    public Users(Long userId, String identification, String name, String lastName, String email, String password) {
        this.userId = userId;
        this.identification = identification;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getIdentification() { return identification; }
    public void setIdentification(String identification) { this.identification = identification; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}