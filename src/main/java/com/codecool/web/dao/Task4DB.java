package com.codecool.web.dao;

import com.codecool.web.model.Task4;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Task4DB {

    private Connection connection;

    public Task4DB(Connection connection) {
        this.connection = connection;
    }

    public List<Task4> getTask4() throws SQLException {
        String sql = "SELECT companyname AS CompanyName, ARRAY_AGG(orderid) AS Orders " +
            "FROM customers " +
            "INNER JOIN orders " +
            "ON customers.customerid = orders.customerid " +
            "GROUP BY companyname " +
            "ORDER BY companyname ASC;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            List<Task4> tempTasks = new ArrayList<>();
            while (resultSet.next()) {
                tempTasks.add(createTask4(resultSet));
            }
            return tempTasks;
        }
    }

    private Task4 createTask4(ResultSet resultSet) throws SQLException {
        String companyName = resultSet.getString("CompanyName");
        Array orders = resultSet.getArray("Orders");
        Short[] temp = (Short[]) orders.getArray();
        return new Task4(companyName, temp);
    }

    public List<Task4> getTask4(String filter) throws SQLException {
        String sql = "SELECT companyname AS CompanyName, ARRAY_AGG(orderid) AS Orders " +
            "FROM customers " +
            "INNER JOIN orders " +
            "ON customers.customerid = orders.customerid " +
            "WHERE companyname LIKE ? "+
            "GROUP BY companyname " +
            "ORDER BY companyname ASC;";
        List<Task4> filteredTask = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1,filter + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    filteredTask.add(createTask4(resultSet));
                }
            }
        }
        return filteredTask;
    }



}
