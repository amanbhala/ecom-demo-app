package com.demoapplication.demoapplication;

import java.util.Objects;

//import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "customers")
public class customers {
   
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Id
   private int cust_id;
   private String name;
   private String email;
   private String mobile;


    public customers() {
    }

    public customers(final int cust_id, final String name, final String email, final String mobile) {
        this.cust_id = cust_id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    public int getCust_id() {
        return this.cust_id;
    }

    public void setCust_id(final int cust_id) {
        this.cust_id = cust_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(final String mobile) {
        this.mobile = mobile;
    }

    public customers cust_id(final int cust_id) {
        this.cust_id = cust_id;
        return this;
    }

    public customers name(final String name) {
        this.name = name;
        return this;
    }

    public customers email(final String email) {
        this.email = email;
        return this;
    }

    public customers mobile(final String mobile) {
        this.mobile = mobile;
        return this;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this)
            return true;
        if (!(o instanceof customers)) {
            return false;
        }
        final customers customers = (customers) o;
        return cust_id == customers.cust_id && Objects.equals(name, customers.name) && Objects.equals(email, customers.email) && Objects.equals(mobile, customers.mobile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cust_id, name, email, mobile);
    }

    @Override
    public String toString() {
        return "{" +
            " cust_id='" + getCust_id() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", mobile='" + getMobile() + "'" +
            "}";
    }
   
    
    

    
}
