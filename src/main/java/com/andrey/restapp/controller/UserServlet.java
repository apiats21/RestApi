package com.andrey.restapp.controller;

import com.andrey.restapp.model.User;
import com.andrey.restapp.service.impl.UserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/api/v1/user")
public class UserServlet extends HttpServlet {

    private final UserServiceImpl userService;

    public UserServlet() {
        this.userService = new UserServiceImpl();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        userService.create(user);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("idEdit"));
        String firstName = request.getParameter("firstNameEdit");
        String lastName = request.getParameter("lastNameEdit");
        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        userService.update(user);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long userById = Long.parseLong(request.getParameter("userById"));
        User user = userService.getById(userById);
        if (user == null) {
            List<User> listUser = userService.getAll();
            request.setAttribute("listUser", listUser);

            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            for (User result : listUser) {
                out.println(result);
            }
        } else {
            PrintWriter out = response.getWriter();
            out.println(user);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("idDelete"));
        userService.delete(id);
    }
}