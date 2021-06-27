package com.example.FinalJavaProject.Models;

import java.util.Set;
import javax.persistence.*;
import java.util.UUID;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "user")
public class User {


    @Id
    @Column (name = "userid")
    private String userId;

    @Column (name = "username")
    private String userName;

    @Column (name = "firstname")
    private String firstName;

    @Column (name = "lastname")
    private String lastName;

    @Column (name = "email")
    private String email;

    @Column (name = "password")
    private String password;

    @Column (name = "isadmin")
    private boolean isAdmin;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userid"), inverseJoinColumns =
    @JoinColumn(name = "roleid"))
    private Set<Role> roles;

    //constructors
    public User(String userId, String userName, String firstName, String lastName,
                String email, String password, boolean isAdmin){
        userId = UUID.randomUUID().toString();
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;

    }


    public User(){

    }


    //Setters and Getters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }





}
