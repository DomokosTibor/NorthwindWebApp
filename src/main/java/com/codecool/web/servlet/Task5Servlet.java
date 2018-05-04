package com.codecool.web.servlet;

import com.codecool.web.dao.Task5DB;
import com.codecool.web.service.Task5Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/Task5Servlet")
public class Task5Servlet extends TaskAbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task5DB t5db = new Task5DB(connection);
            Task5Service t5service = new Task5Service(t5db);
            req.setAttribute("task",t5service.t5());
            req.getRequestDispatcher("task5.jsp").forward(req, resp);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task5DB t5db = new Task5DB(connection);
            Task5Service t5service = new Task5Service(t5db);
            String filter = req.getParameter("filter");
            req.setAttribute("task",t5service.t5filter(filter));
            req.getRequestDispatcher("task5.jsp").forward(req, resp);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
