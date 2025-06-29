package org.valencia.todo_web_ui;

import entity.Item;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.persistence.*;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/todo", "/add", "/delete"})
public class ToDoServlet extends HttpServlet {
    private Actions actions;

    @Override
    public void init() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        actions = new Actions(emf);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getServletPath();

        if ("/delete".equals(path)) {
            String idParam = request.getParameter("id");
            if (idParam != null) {
                int id = Integer.parseInt(idParam);
                actions.deleteItem(id);
            }
            response.sendRedirect("todo");
            return;
        }

        // Default: show list
        List<Item> items = actions.getAllItems();
        request.setAttribute("items", items);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();

        if ("/add".equals(path)) {
            String text = request.getParameter("text");
            if (text != null && !text.trim().isEmpty()) {
                actions.addItem(text.trim());
            }
        }

        response.sendRedirect("todo");
    }
}
