package com.codecool.web.service;

import com.codecool.web.dao.Task4DB;
import com.codecool.web.model.Task4;

import java.sql.SQLException;
import java.util.List;

public class Task4Service {

    private Task4DB db;

    public Task4Service(Task4DB db) {
        this.db = db;
    }

    public List<Task4> t4() throws SQLException {
        List<Task4> result = db.getTask4();
        return result;
    }

    public List<Task4> t4filter(String filter) throws SQLException {
        List<Task4> result = db.getTask4(filter);
        return result;
    }
}
