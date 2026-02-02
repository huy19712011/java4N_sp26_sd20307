package org.example.java4n_sp26_sd20307.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "FilterDemo", urlPatterns = "/filterInput")
public class FilterDemo implements Filter {

    public void init(FilterConfig config) throws ServletException {

        Filter.super.init(config);
    }

    public void destroy() {

        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        String username = request.getParameter("name");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();

        if (username.equals("fpoly") & password.equals("123456")) {


            chain.doFilter(request, response);
        }

        else {

            out.println("Invalid username or password");
        }


    }
}