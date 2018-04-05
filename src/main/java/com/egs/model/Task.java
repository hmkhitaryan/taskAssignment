package com.egs.model;


import com.egs.enums.Severity;
import com.egs.enums.Status;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @author Hayk_Mkhitaryan
 */
@Entity
@Table(name = "impl")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "REPORTER_USER_ID")
    private User reporterUser;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ASSIGNEE_USER_ID")
    private User assigneeUser;

    private Severity severity;

    private Status status;

    private Date createdDate;

    private String description;

    public User getAssigneeUser() {
        return assigneeUser;
    }

    public void setAssigneeUser(User assigneeUser) {
        this.assigneeUser = assigneeUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getReporterUser() {
        return reporterUser;
    }

    public void setReporterUser(User reporterUser) {
        this.reporterUser = reporterUser;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) &&
                Objects.equals(reporterUser, task.reporterUser) &&
                Objects.equals(assigneeUser, task.assigneeUser) &&
                severity == task.severity &&
                status == task.status &&
                Objects.equals(createdDate, task.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reporterUser, assigneeUser, severity, status, createdDate);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", reporterUser=" + reporterUser +
                ", assigneeUser=" + assigneeUser +
                ", severity=" + severity +
                ", status=" + status +
                ", createdDate=" + createdDate +
                '}';
    }
}
