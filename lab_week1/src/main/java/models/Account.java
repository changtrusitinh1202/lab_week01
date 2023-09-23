package models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "account_id", nullable = false, columnDefinition = "VARCHAR(50)")
    private String id;
    @Column(name = "full_name", columnDefinition = "VARCHAR(50)")
    private String fullName;
    @Column(columnDefinition = "VARCHAR(50)")
    private String password;
    @Column(columnDefinition = "VARCHAR(50)")
    private String email;
    @Column(columnDefinition = "VARCHAR(50)")
    private String phone;
    @Enumerated(EnumType.ORDINAL)
    @Column(columnDefinition = "TINYINT(4)")
    private AccessStatus status;

    public Account() {
    }

    public Account(String id, String fullName, String password, String email, String phone, AccessStatus status) {
        this.id = id;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

    public Account(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public AccessStatus getStatus() {
        return status;
    }

    public void setStatus(AccessStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                '}';
    }
}
