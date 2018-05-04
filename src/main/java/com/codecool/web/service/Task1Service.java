package com.codecool.web.service;

import com.codecool.web.dao.Task1DB;
import com.codecool.web.model.Task1;
import java.sql.SQLException;
import java.util.List;

public class Task1Service {

    private Task1DB db;

    public Task1Service(Task1DB db) {
        this.db = db;
    }

    public List<Task1> t1() throws SQLException {
        List<Task1> result = db.getTask1();
        return result;
    }

    public List<Task1> t1filter(String filter) throws SQLException {
        List<Task1> result = db.getTask1(filter);
        return result;
    }
}
