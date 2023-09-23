package models;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.io.Serializable;
import java.time.LocalDateTime;
@Entity
@Table(name = "log")
public class Log implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BIGINT")
    private long id;
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
    @Column(name = "login_time", columnDefinition = "DATETIME")
    private LocalDateTime logInTime;
    @Column(name = "logout_time", columnDefinition = "DATETIME")
    private LocalDateTime logOutTime;
    @Column(columnDefinition = "VARCHAR(250)")
    private String notes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public LocalDateTime getLogInTime() {
        return logInTime;
    }

    public void setLogInTime(LocalDateTime logInTime) {
        this.logInTime = logInTime;
    }

    public LocalDateTime getLogOutTime() {
        return logOutTime;
    }

    public void setLogOutTime(LocalDateTime logOutTime) {
        this.logOutTime = logOutTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Log() {
    }

    public Log(long id, Account account, LocalDateTime logInTime, LocalDateTime logOutTime, String notes) {
        this.id = id;
        this.account = account;
        this.logInTime = logInTime;
        this.logOutTime = logOutTime;
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", account=" + account +
                ", logInTime=" + logInTime +
                ", logOutTime=" + logOutTime +
                ", notes='" + notes + '\'' +
                '}';
    }
}
