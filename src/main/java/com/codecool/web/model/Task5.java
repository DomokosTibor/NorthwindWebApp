package com.codecool.web.model;

public class Task5 extends TaskAbstract {

    private String productName;
    private double unitPrice;

    public Task5(String companyName, String productName, double unitPrice) {
        super(companyName);
        this.productName = productName;
        this.unitPrice = unitPrice;
    }

    public String getProductName() {
        return productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}
