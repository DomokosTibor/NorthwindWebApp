package com.codecool.web.model;

public abstract class TaskAbstract {

    String companyName;

    TaskAbstract(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

}
