package com.example.demo.model.user1;


import javax.persistence.*;


@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(targetEntity = User.class)
    private User user;
    @ManyToOne(targetEntity = Role.class)
    private Role role;

    public UserRole() {
    }

    public UserRole(Integer id, User user, Role role) {
        this.id = id;
        this.user = user;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
