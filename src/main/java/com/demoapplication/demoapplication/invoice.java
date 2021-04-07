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
@Table(name = "invoice")
public class invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoice_id;
    private int cust_id;
    // private int mat_id;
    // private int supp_id;
    private int unit_purchased;

    @ManyToOne
    @JoinColumn(name = "supp_id")
    supplier supplier;

    @ManyToOne
    @JoinColumn(name = "mat_id")
    material material;

    public invoice() {
    }


    public invoice(int invoice_id, int cust_id, int unit_purchased, supplier supplier, material material) {
        this.invoice_id = invoice_id;
        this.cust_id = cust_id;
        this.unit_purchased = unit_purchased;
        this.supplier = supplier;
        this.material = material;
    }

    public int getInvoice_id() {
        return this.invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public int getCust_id() {
        return this.cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    public int getUnit_purchased() {
        return this.unit_purchased;
    }

    public void setUnit_purchased(int unit_purchased) {
        this.unit_purchased = unit_purchased;
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

    public invoice invoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
        return this;
    }

    public invoice cust_id(int cust_id) {
        this.cust_id = cust_id;
        return this;
    }

    public invoice unit_purchased(int unit_purchased) {
        this.unit_purchased = unit_purchased;
        return this;
    }

    public invoice supplier(supplier supplier) {
        this.supplier = supplier;
        return this;
    }

    public invoice material(material material) {
        this.material = material;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof invoice)) {
            return false;
        }
        invoice invoice = (invoice) o;
        return invoice_id == invoice.invoice_id && cust_id == invoice.cust_id && unit_purchased == invoice.unit_purchased && Objects.equals(supplier, invoice.supplier) && Objects.equals(material, invoice.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoice_id, cust_id, unit_purchased, supplier, material);
    }

    @Override
    public String toString() {
        return "{" +
            " invoice_id='" + getInvoice_id() + "'" +
            ", cust_id='" + getCust_id() + "'" +
            ", unit_purchased='" + getUnit_purchased() + "'" +
            ", supplier='" + getSupplier() + "'" +
            ", material='" + getMaterial() + "'" +
            "}";
    }

    
    
}
