package com.demoapplication.demoapplication;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "supplier")
public class supplier {
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int supp_id;
    private String name;
    private String email;
    private String mobile;
    // private Set<material> materials = new HashSet<>();

    // @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	// @JoinTable(name = "msconnection",
	// 	joinColumns = { @JoinColumn(name = "supp_id")},
	// 	inverseJoinColumns = { @JoinColumn (name = "mat_id")})
    // private Set<material> materials = new HashSet<>();
    

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "supplier")
    Set<material_supplier> material_supplier;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "supplier")
    Set<invoice> invoice;

    // public Set<material> getMaterials() {
    //     return materials;
    // }

    // public void setMaterials(Set<material> materials) {
    //     this.materials = materials;
	// }
    public supplier() {
    }


    public supplier(final int supp_id, final String name, final String email, final String mobile) {
        this.supp_id = supp_id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    public int getSupp_id() {
        return this.supp_id;
    }

    public void setSupp_id(final int supp_id) {
        this.supp_id = supp_id;
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

    public supplier supp_id(final int supp_id) {
        this.supp_id = supp_id;
        return this;
    }

    public supplier name(final String name) {
        this.name = name;
        return this;
    }

    public supplier email(final String email) {
        this.email = email;
        return this;
    }

    public supplier mobile(final String mobile) {
        this.mobile = mobile;
        return this;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this)
            return true;
        if (!(o instanceof supplier)) {
            return false;
        }
        final supplier supplier = (supplier) o;
        return supp_id == supplier.supp_id && Objects.equals(name, supplier.name) && Objects.equals(email, supplier.email) && Objects.equals(mobile, supplier.mobile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supp_id, name, email, mobile);
    }

    @Override
    public String toString() {
        return "{" +
            " supp_id='" + getSupp_id() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", mobile='" + getMobile() + "'" +
            "}";
    }

    
}
