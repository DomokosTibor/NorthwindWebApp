package com.codecool.web.service;

import com.codecool.web.dao.Task5DB;
import com.codecool.web.model.Task5;

import java.sql.SQLException;
import java.util.List;

public class Task5Service {

    private Task5DB db;

    public Task5Service(Task5DB db) {
        this.db = db;
    }

    public List<Task5> t5() throws SQLException {
        List<Task5> result = db.getTask5();
        return result;
    }

    public List<Task5> t5filter(String filter) throws SQLException {
        List<Task5> result = db.getTask5(filter);
        return result;
    }
}
