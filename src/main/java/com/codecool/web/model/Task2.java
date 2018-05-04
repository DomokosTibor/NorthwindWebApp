package com.codecool.web.model;

public class Task2 extends TaskAbstract {

    private int numberOfProducts;

    public Task2(String companyName, int numberOfProducts) {
        super(companyName);
        this.numberOfProducts = numberOfProducts;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

}
