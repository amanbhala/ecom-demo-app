package com.demoapplication.demoapplication.model;

import javax.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private Long role_id;

    @Column(name = "NAME", unique = true)
    private String name;

    // @ManyToMany(mappedBy = "roles")
    // private Set<User> users;


    public Role() {
    }

    public Role(Long role_id, String name) {
        this.role_id = role_id;
        this.name = name;
    }

    public Long getRole_id() {
        return this.role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // public Role role_id(Long role_id) {
    //     this.role_id = role_id;
    //     return this;
    // }

    // public Role name(String name) {
    //     this.name = name;
    //     return this;
    // }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Role)) {
            return false;
        }
        Role role = (Role) o;
        return Objects.equals(role_id, role.role_id) && Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role_id, name);
    }

    @Override
    public String toString() {
        return "{" +
            " role_id='" + getRole_id() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }
      
   
   
    
}
