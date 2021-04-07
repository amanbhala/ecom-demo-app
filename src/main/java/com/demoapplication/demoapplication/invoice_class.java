package com.demoapplication.demoapplication;

import java.util.Objects;

public class invoice_class {
    private int invoice_id;
    private int cust_id;
    private int mat_id;
    private int supp_id;
    private int unit_purchased;

    public invoice_class() {
    }

    public invoice_class(int invoice_id, int cust_id, int mat_id, int supp_id, int unit_purchased) {
        this.invoice_id = invoice_id;
        this.cust_id = cust_id;
        this.mat_id = mat_id;
        this.supp_id = supp_id;
        this.unit_purchased = unit_purchased;
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

    public int getMat_id() {
        return this.mat_id;
    }

    public void setMat_id(int mat_id) {
        this.mat_id = mat_id;
    }

    public int getSupp_id() {
        return this.supp_id;
    }

    public void setSupp_id(int supp_id) {
        this.supp_id = supp_id;
    }

    public int getUnit_purchased() {
        return this.unit_purchased;
    }

    public void setUnit_purchased(int unit_purchased) {
        this.unit_purchased = unit_purchased;
    }

    public invoice_class invoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
        return this;
    }

    public invoice_class cust_id(int cust_id) {
        this.cust_id = cust_id;
        return this;
    }

    public invoice_class mat_id(int mat_id) {
        this.mat_id = mat_id;
        return this;
    }

    public invoice_class supp_id(int supp_id) {
        this.supp_id = supp_id;
        return this;
    }

    public invoice_class unit_purchased(int unit_purchased) {
        this.unit_purchased = unit_purchased;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof invoice_class)) {
            return false;
        }
        invoice_class invoice_class = (invoice_class) o;
        return invoice_id == invoice_class.invoice_id && cust_id == invoice_class.cust_id && mat_id == invoice_class.mat_id && supp_id == invoice_class.supp_id && unit_purchased == invoice_class.unit_purchased;
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoice_id, cust_id, mat_id, supp_id, unit_purchased);
    }

    @Override
    public String toString() {
        return "{" +
            " invoice_id='" + getInvoice_id() + "'" +
            ", cust_id='" + getCust_id() + "'" +
            ", mat_id='" + getMat_id() + "'" +
            ", supp_id='" + getSupp_id() + "'" +
            ", unit_purchased='" + getUnit_purchased() + "'" +
            "}";
    }
}
