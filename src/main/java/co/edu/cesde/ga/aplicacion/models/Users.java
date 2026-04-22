package co.edu.cesde.ga.aplicacion.models;

import java.time.LocalDateTime;

public class Users {
    private Long userId; // user_id
    private String username; // username
    private String email; // email
    private String passwordHash; // password_hash
    private String status; // status
    private LocalDateTime createdAt; // created_at

    public Users() {}

    public Users(Long userId, String username, String email, String passwordHash, String status, LocalDateTime createdAt) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.status = status;
        this.createdAt = createdAt;
    }

    // Getters y Setters con camelCase
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
