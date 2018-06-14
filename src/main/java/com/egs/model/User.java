package com.egs.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    @JsonIgnore
    private String password;

    @OneToMany(mappedBy = "reporterUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Task> assignedTasks;

    @OneToMany(mappedBy = "assigneeUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Task> reportedTasks;

    @OneToMany(mappedBy = "reporterUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Notification>  reportedNotes;

    @OneToMany(mappedBy = "assigneeUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Notification> assignedNotes;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JsonIgnore
    private Set<Role> roles;

    public User() {
    }

    public User(String username, Set<Role> roles) {
        this.username = username;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, username, password, roles);
    }
}
