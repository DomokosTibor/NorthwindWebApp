package com.codecool.web.dao;

import com.codecool.web.model.Task3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Task3DB {

    private Connection connection;

    public Task3DB(Connection connection) {
        this.connection = connection;
    }

    public List<Task3> getTask3() throws SQLException {
        String sql = "SELECT companyname AS CompanyName " +
            "FROM products " +
            "INNER JOIN suppliers " +
            "ON products.supplierid = suppliers.supplierid " +
            "GROUP BY companyname " +
            "HAVING COUNT(productname) = 5;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            List<Task3> tempTasks = new ArrayList<>();
            while (resultSet.next()) {
                tempTasks.add(createTask3(resultSet));
            }
            return tempTasks;
        }
    }

    private Task3 createTask3(ResultSet resultSet) throws SQLException {
        String companyName = resultSet.getString("CompanyName");
        return new Task3(companyName);
    }

    public List<Task3> getTask3(String filter) throws SQLException {
        String sql = "SELECT companyname AS CompanyName " +
            "FROM products " +
            "INNER JOIN suppliers " +
            "ON products.supplierid = suppliers.supplierid " +
            "WHERE companyname LIKE ? " +
            "GROUP BY companyname " +
            "HAVING COUNT(productname) = 5;";
        List<Task3> filteredTask = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1,filter + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    filteredTask.add(createTask3(resultSet));
                }
            }
        }
        return filteredTask;
    }



}
