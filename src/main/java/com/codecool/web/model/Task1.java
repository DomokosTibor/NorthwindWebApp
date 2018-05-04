package com.codecool.web.model;

public class Task1 extends TaskAbstract {

    private String productName;

    public Task1(String companyName, String productName) {
        super(companyName);
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

}
