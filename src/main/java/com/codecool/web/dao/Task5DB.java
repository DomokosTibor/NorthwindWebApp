package com.codecool.web.dao;

import com.codecool.web.model.Task5;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Task5DB {

    private Connection connection;

    public Task5DB(Connection connection) {
        this.connection = connection;
    }

    public List<Task5> getTask5() throws SQLException {
        String sql = "SELECT companyname, productname, unitprice " +
            "FROM products " +
            "INNER JOIN suppliers " +
            "ON products.supplierid = suppliers.supplierid " +
            "ORDER BY unitprice DESC, companyname ASC;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            List<Task5> tempTasks = new ArrayList<>();
            while (resultSet.next()) {
                tempTasks.add(createTask5(resultSet));
            }
            return tempTasks;
        }
    }

    private Task5 createTask5(ResultSet resultSet) throws SQLException {
        String companyName = resultSet.getString("CompanyName");
        String productName = resultSet.getString("ProductName");
        double unitPrice = resultSet.getInt("UnitPrice");
        return new Task5(companyName, productName, unitPrice);
    }

    public List<Task5> getTask5(String filter) throws SQLException {
        String sql = "SELECT companyname, productname, unitprice " +
            "FROM products " +
            "INNER JOIN suppliers " +
            "ON products.supplierid = suppliers.supplierid " +
            "WHERE companyname LIKE ? " +
            "ORDER BY unitprice DESC, companyname ASC;";
        List<Task5> filteredTask = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1,filter + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    filteredTask.add(createTask5(resultSet));
                }
            }
        }
        return filteredTask;
    }



}
