package com.example.FinalJavaProject.Models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;


@Entity
@Table(name = "role")

public class Role {
    @Id
    @Column(name = "roleid")
    private String roleId;

    @Column(name = "role_name")
    private String role;

    @Column(name = "role_desc")
    private String description;


    //Constructors
    public Role(String role, String description){
        roleId = UUID.randomUUID().toString();
        this.role = role;
        this.description = description;
    }

    public Role(){

    }


    //Setters and Getters
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
