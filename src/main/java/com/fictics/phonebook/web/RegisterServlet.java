package com.fictics.phonebook.web;

import com.fictics.phonebook.entity.User;
import com.fictics.phonebook.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if(user!=null){
            resp.sendRedirect("./dashboard");
            return;
        }
        req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String cPassword = req.getParameter("c_password");

        UserService userService = new UserService();
        Map<String, String> errors = new HashMap<>();
        User user = userService.registerUser(name, email, password, cPassword, errors);

        if(errors.size()>0){
            req.setAttribute("errors",errors);
            req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req,resp);
        }else {
            req.getSession().setAttribute("user",user);
            resp.sendRedirect("./dashboard");
        }
    }
}
