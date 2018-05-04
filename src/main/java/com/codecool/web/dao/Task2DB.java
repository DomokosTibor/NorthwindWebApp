package com.codecool.web.dao;

import com.codecool.web.model.Task2;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Task2DB {

    private Connection connection;

    public Task2DB(Connection connection) {
        this.connection = connection;
    }

    public List<Task2> getTask2() throws SQLException {
        String sql = "SELECT companyname AS CompanyName, count(*) AS NumberOfProducts " +
            "FROM suppliers " +
            "INNER JOIN products " +
            "ON products.supplierid = suppliers.supplierid " +
            "GROUP BY companyname " +
            "ORDER BY count(*) DESC, companyname ASC;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            List<Task2> tempTasks = new ArrayList<>();
            while (resultSet.next()) {
                tempTasks.add(createTask2(resultSet));
            }
            return tempTasks;
        }
    }

    private Task2 createTask2(ResultSet resultSet) throws SQLException {
        String companyName = resultSet.getString("CompanyName");
        int numberOfProducts = resultSet.getInt("NumberOfProducts");
        return new Task2(companyName, numberOfProducts);
    }

    public List<Task2> getTask2(String filter) throws SQLException {
        String sql = "SELECT companyname AS CompanyName, count(*) AS NumberOfProducts " +
            "FROM suppliers " +
            "INNER JOIN products " +
            "ON products.supplierid = suppliers.supplierid " +
            "WHERE companyname LIKE ? " +
            "GROUP BY companyname " +
            "ORDER BY count(*) DESC, companyname ASC;";
        List<Task2> filteredTask = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1,filter + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    filteredTask.add(createTask2(resultSet));
                }
            }
        }
        return filteredTask;
    }



}
