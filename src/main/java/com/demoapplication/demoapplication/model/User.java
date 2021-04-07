package com.demoapplication.demoapplication.model;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long user_id;

    private String username;

    private String password;

    private String user_type;

    @Transient
    private String passwordConfirm;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "USER_ROLES",
        joinColumns = @JoinColumn(
        name = "USER_ID", referencedColumnName = "USER_ID"),
        inverseJoinColumns = @JoinColumn(
        name = "ROLE_ID", referencedColumnName = "ROLE_ID"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(Long user_id, String username, String password, String user_type, String passwordConfirm, Set<Role> roles) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.user_type = user_type;
        this.passwordConfirm = passwordConfirm;
        this.roles = roles;
    }

    public Long getUser_id() {
        return this.user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_type() {
        return this.user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getPasswordConfirm() {
        return this.passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    // public User user_id(Long user_id) {
    //     this.user_id = user_id;
    //     return this;
    // }

    // public User username(String username) {
    //     this.username = username;
    //     return this;
    // }

    // public User password(String password) {
    //     this.password = password;
    //     return this;
    // }

    // public User user_type(String user_type) {
    //     this.user_type = user_type;
    //     return this;
    // }

    // public User passwordConfirm(String passwordConfirm) {
    //     this.passwordConfirm = passwordConfirm;
    //     return this;
    // }

    // public User roles(Set<Role> roles) {
    //     this.roles = roles;
    //     return this;
    // }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(user_id, user.user_id) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(user_type, user.user_type) && Objects.equals(passwordConfirm, user.passwordConfirm) && Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, username, password, user_type, passwordConfirm, roles);
    }

    @Override
    public String toString() {
        return "{" +
            " user_id='" + getUser_id() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", user_type='" + getUser_type() + "'" +
            ", passwordConfirm='" + getPasswordConfirm() + "'" +
            ", roles='" + getRoles() + "'" +
            "}";
    }


   
   
}
