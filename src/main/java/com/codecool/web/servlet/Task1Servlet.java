package com.codecool.web.servlet;

import com.codecool.web.dao.Task1DB;
import com.codecool.web.service.Task1Service;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/Task1Servlet")
public class Task1Servlet extends TaskAbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task1DB t1db = new Task1DB(connection);
            Task1Service t1service = new Task1Service(t1db);
            req.setAttribute("task",t1service.t1());
            req.getRequestDispatcher("task1.jsp").forward(req, resp);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task1DB t1db = new Task1DB(connection);
            Task1Service t1service = new Task1Service(t1db);
            String filter = req.getParameter("filter");
            req.setAttribute("task",t1service.t1filter(filter));
            req.getRequestDispatcher("task1.jsp").forward(req, resp);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
