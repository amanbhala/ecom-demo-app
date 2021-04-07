package com.demoapplication.demoapplication;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
// import javax.persistence.Table;
import javax.persistence.Table;

@Entity
@Table(name = "material")
public class material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mat_id;
    private String name;
    private String details;

    // @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "materials")
	// private Set<supplier> suppliers;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "material")
    Set<material_supplier> material_supplier;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "material")
    Set<invoice> invoice;

    // public Set<supplier> getSuppliers() {
    //     return suppliers;
    // }

    // public void setSuppliers(Set<supplier> suppliers) {
    //     this.suppliers = suppliers;
    // }
    
    public material() {
    }

    public material(int mat_id, String name, String details) {
        this.mat_id = mat_id;
        this.name = name;
        this.details = details;
    }

    public int getMat_id() {
        return this.mat_id;
    }

    public void setMat_id(int mat_id) {
        this.mat_id = mat_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public material mat_id(int mat_id) {
        this.mat_id = mat_id;
        return this;
    }

    public material name(String name) {
        this.name = name;
        return this;
    }

    public material details(String details) {
        this.details = details;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof material)) {
            return false;
        }
        material material = (material) o;
        return mat_id == material.mat_id && Objects.equals(name, material.name) && Objects.equals(details, material.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mat_id, name, details);
    }

    @Override
    public String toString() {
        return "{" +
            " mat_id='" + getMat_id() + "'" +
            ", name='" + getName() + "'" +
            ", details='" + getDetails() + "'" +
            "}";
    }

   
    
}
