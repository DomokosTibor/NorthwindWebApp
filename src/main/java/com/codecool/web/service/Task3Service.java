package com.codecool.web.service;

import com.codecool.web.dao.Task3DB;
import com.codecool.web.model.Task3;

import java.sql.SQLException;
import java.util.List;

public class Task3Service {

    private Task3DB db;

    public Task3Service(Task3DB db) {
        this.db = db;
    }

    public List<Task3> t3() throws SQLException {
        List<Task3> result = db.getTask3();
        return result;
    }

    public List<Task3> t3filter(String filter) throws SQLException {
        List<Task3> result = db.getTask3(filter);
        return result;
    }
}
