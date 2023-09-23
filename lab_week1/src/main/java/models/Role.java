package models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "role")
public class Role implements Serializable {
    @Id
    @Column(name = "role_id", nullable = false)
    private String id;
    @Column(name = "role_name", columnDefinition = "VARCHAR{50)")
    private String roleName;
    @Column(columnDefinition = "VARCHAR{50)")
    private String description;
    @Enumerated
    @Column(columnDefinition = "TINYINT(4)")
    private AccessStatus status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AccessStatus getStatus() {
        return status;
    }

    public void setStatus(AccessStatus status) {
        this.status = status;
    }

    public Role() {
    }

    public Role(String id, String roleName, String description, AccessStatus status) {
        this.id = id;
        this.roleName = roleName;
        this.description = description;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
