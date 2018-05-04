package com.codecool.web.dao;

import com.codecool.web.model.Task1;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Task1DB {

    private Connection connection;

    public Task1DB(Connection connection) {
        this.connection = connection;
    }

    public List<Task1> getTask1() throws SQLException {
        String sql = "SELECT productname AS ProductName, companyname AS CompanyName " +
            "FROM products " +
            "INNER JOIN suppliers " +
            "ON products.supplierid = suppliers.supplierid " +
            "ORDER BY productname ASC;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            List<Task1> tempTasks = new ArrayList<>();
            while (resultSet.next()) {
                tempTasks.add(createTask1(resultSet));
            }
            return tempTasks;
        }
    }

    private Task1 createTask1(ResultSet resultSet) throws SQLException {
        String companyName = resultSet.getString("CompanyName");
        String productName = resultSet.getString("ProductName");
        return new Task1(companyName, productName);
    }

    public List<Task1> getTask1(String filter) throws SQLException {
        String sql = "SELECT productname AS ProductName, companyname AS CompanyName " +
            "FROM products " +
            "INNER JOIN suppliers " +
            "ON products.supplierid = suppliers.supplierid " +
            "WHERE companyname LIKE ? " +
            "ORDER BY productname ASC;";
        List<Task1> filteredTask = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1,filter + "%");
            System.out.println(filter);
            System.out.println(statement);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    filteredTask.add(createTask1(resultSet));
                }
            }
        }
        return filteredTask;
    }



}
