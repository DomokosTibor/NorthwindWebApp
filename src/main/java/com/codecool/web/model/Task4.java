package com.codecool.web.model;

public class Task4 extends TaskAbstract {

    private Short[] orders;

    public Task4(String companyName, Short[] orders) {
        super(companyName);
        this.orders = orders;
    }

    public Short[] getOrders() {
        return orders;
    }

}
