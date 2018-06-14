package com.egs.model;

import com.egs.enums.Type;

import javax.persistence.*;

/**
 * @author Hayk_Mkhitaryan
 */
@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false,  fetch = FetchType.LAZY)
    @JoinColumn(name = "REPORTER_USER_ID")
    private User reporterUser;

    @ManyToOne(optional = false,  fetch = FetchType.LAZY)
    @JoinColumn(name = "ASSIGNEE_USER_ID")
    private User assigneeUser;

    private String comment;

    private Type type;

    public Notification(User reporterUser, User assigneeUser, String comment, Type type) {
        this.reporterUser = reporterUser;
        this.assigneeUser = assigneeUser;
        this.comment = comment;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getReporterUser() {
        return reporterUser;
    }

    public void setReporterUser(User reporterUser) {
        this.reporterUser = reporterUser;
    }

    public User getAssigneeUser() {
        return assigneeUser;
    }

    public void setAssigneeUser(User assigneeUser) {
        this.assigneeUser = assigneeUser;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
