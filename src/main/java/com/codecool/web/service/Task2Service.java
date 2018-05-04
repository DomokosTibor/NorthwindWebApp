package com.codecool.web.service;

import com.codecool.web.dao.Task2DB;
import com.codecool.web.model.Task2;
import java.sql.SQLException;
import java.util.List;

public class Task2Service {

    private Task2DB db;

    public Task2Service(Task2DB db) {
        this.db = db;
    }

    public List<Task2> t2() throws SQLException {
        List<Task2> result = db.getTask2();
        return result;
    }

    public List<Task2> t2filter(String filter) throws SQLException {
        List<Task2> result = db.getTask2(filter);
        return result;
    }
}
