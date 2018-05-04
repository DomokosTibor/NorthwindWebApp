package com.codecool.web.servlet;

import com.codecool.web.dao.Task4DB;
import com.codecool.web.service.Task4Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/Task4Servlet")
public class Task4Servlet extends TaskAbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task4DB t4db = new Task4DB(connection);
            Task4Service t4service = new Task4Service(t4db);
            req.setAttribute("task",t4service.t4());
            req.getRequestDispatcher("task4.jsp").forward(req, resp);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task4DB t4db = new Task4DB(connection);
            Task4Service t4service = new Task4Service(t4db);
            String filter = req.getParameter("filter");
            req.setAttribute("task",t4service.t4filter(filter));
            req.getRequestDispatcher("task4.jsp").forward(req, resp);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
