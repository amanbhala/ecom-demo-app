package com.demoapplication.demoapplication;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "material_supplier")
public class material_supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int msid;
    // private int mat_id;
    // private int supp_id;
    private int units;

    @ManyToOne
    @JoinColumn(name = "supp_id")
    supplier supplier;

    @ManyToOne
    @JoinColumn(name = "mat_id")
    material material;

    
    public material_supplier() {
    }

    public material_supplier(int msid, int units, supplier supplier, material material) {
        this.msid = msid;
        this.units = units;
        this.supplier = supplier;
        this.material = material;
    }

    public int getMsid() {
        return this.msid;
    }

    public void setMsid(int msid) {
        this.msid = msid;
    }

    public int getUnits() {
        return this.units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public supplier getSupplier() {
        return this.supplier;
    }

    public void setSupplier(supplier supplier) {
        this.supplier = supplier;
    }

    public material getMaterial() {
        return this.material;
    }

    public void setMaterial(material material) {
        this.material = material;
    }

    public material_supplier msid(int msid) {
        this.msid = msid;
        return this;
    }

    public material_supplier units(int units) {
        this.units = units;
        return this;
    }

    public material_supplier supplier(supplier supplier) {
        this.supplier = supplier;
        return this;
    }

    public material_supplier material(material material) {
        this.material = material;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof material_supplier)) {
            return false;
        }
        material_supplier material_supplier = (material_supplier) o;
        return msid == material_supplier.msid && units == material_supplier.units && Objects.equals(supplier, material_supplier.supplier) && Objects.equals(material, material_supplier.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msid, units, supplier, material);
    }

    @Override
    public String toString() {
        return "{" +
            " msid='" + getMsid() + "'" +
            ", units='" + getUnits() + "'" +
            ", supplier='" + getSupplier() + "'" +
            ", material='" + getMaterial() + "'" +
            "}";
    }

	public static Object findAll() {
		return null;
	}

    
    
}
