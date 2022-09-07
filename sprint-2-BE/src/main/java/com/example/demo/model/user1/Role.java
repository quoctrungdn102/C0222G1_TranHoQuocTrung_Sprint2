package com.example.demo.model.user1;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameRole;
    @OneToMany(mappedBy = "role")
    @JsonBackReference("role")
    private List<UserRole> userRoleList;

    public Role() {
    }

    public Role(Integer id, String nameRole, List<UserRole> userRoleList) {
        this.id = id;
        this.nameRole = nameRole;
        this.userRoleList = userRoleList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    public List<UserRole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }
}
