package com.codecool.web.servlet;

import com.codecool.web.dao.Task2DB;
import com.codecool.web.service.Task2Service;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/Task2Servlet")
public class Task2Servlet extends TaskAbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task2DB t2db = new Task2DB(connection);
            Task2Service t2service = new Task2Service(t2db);
            req.setAttribute("task",t2service.t2());
            req.getRequestDispatcher("task2.jsp").forward(req, resp);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task2DB t2db = new Task2DB(connection);
            Task2Service t2service = new Task2Service(t2db);
            String filter = req.getParameter("filter");
            req.setAttribute("task",t2service.t2filter(filter));
            req.getRequestDispatcher("task2.jsp").forward(req, resp);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
