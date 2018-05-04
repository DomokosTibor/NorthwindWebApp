package com.codecool.web.servlet;

import com.codecool.web.dao.Task3DB;
import com.codecool.web.service.Task3Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/Task3Servlet")
public class Task3Servlet extends TaskAbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task3DB t3db = new Task3DB(connection);
            Task3Service t3service = new Task3Service(t3db);
            req.setAttribute("task",t3service.t3());
            req.getRequestDispatcher("task3.jsp").forward(req, resp);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task3DB t3db = new Task3DB(connection);
            Task3Service t3service = new Task3Service(t3db);
            String filter = req.getParameter("filter");
            req.setAttribute("task",t3service.t3filter(filter));
            req.getRequestDispatcher("task3.jsp").forward(req, resp);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
