package com.fictics.phonebook.web;

import com.fictics.phonebook.entity.User;
import com.fictics.phonebook.services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if(user!=null){
            response.sendRedirect("./dashboard");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Map<String,String> errors = new HashMap<>();

        UserService service = new UserService();
        User user = service.login(email,password,errors);

        if(errors.size()>0){
            req.setAttribute("errors",errors);
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req,resp);
        }else{
            req.getSession().setAttribute("user",user);
            resp.sendRedirect("./dashboard");

        }
    }
}
