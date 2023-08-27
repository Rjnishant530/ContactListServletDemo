package com.fictics.phonebook.web;

import com.fictics.phonebook.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(urlPatterns = {"/dasboard"})
public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req= (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        User user = ( User) req.getSession().getAttribute("user");
        if(user==null){
            resp.sendRedirect("./login");
            return;
        }
            chain.doFilter(request, response);

    }
}
