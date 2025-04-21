package com.investasi.model;

import java.util.Objects;

public class Saham {
    private String code;
    private String companyName;
    private double price;

    public Saham(String code, String companyName, double price) {
        this.code = code;
        this.companyName = companyName;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Saham)) return false;
        Saham saham = (Saham) o;
        return Objects.equals(code, saham.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return String.format("%s - %s @ Rp%,.2f",
                code, companyName, price);
    }
}
