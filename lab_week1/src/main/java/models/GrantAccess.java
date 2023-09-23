package models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "grant_access")
public class GrantAccess implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "role_id", columnDefinition = "VARCHAR(50)")
    private Role role;
    @Id
    @ManyToOne
    @JoinColumn(name = "account_id", columnDefinition = "VARCHAR(50)")
    private Account account;
    @Enumerated
    @Column(name = "is_grant", columnDefinition = "TINYINT(4)")
    private GrantStatus isGrant;
    @Column(columnDefinition = "VARCHAR(250)")
    private String note;

    public Role getRole() {
        return role;
    }

    public Account getAccount() {
        return account;
    }

    public GrantStatus getIsGrant() {
        return isGrant;
    }

    public String getNote() {
        return note;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setIsGrant(GrantStatus isGrant) {
        this.isGrant = isGrant;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public GrantAccess() {
    }

    public GrantAccess(Role role, Account account, GrantStatus isGrant, String note) {
        this.role = role;
        this.account = account;
        this.isGrant = isGrant;
        this.note = note;
    }

    @Override
    public String toString() {
        return "GrantAccess{" +
                "role=" + role +
                ", account=" + account +
                ", isGrant=" + isGrant +
                ", note='" + note + '\'' +
                '}';
    }
}
