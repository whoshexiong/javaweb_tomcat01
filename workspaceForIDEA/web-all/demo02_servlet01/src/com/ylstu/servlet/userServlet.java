package com.ylstu.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="UserServlet",value="/userServlet")
public class userServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String username = req.getParameter("username");

        String info ="No";

        if(username.equals("admin")){
            info = "Yes";
        }

        resp.setHeader("content-type", "text/html;charset=utf-8");
        resp.getWriter().println(info);
    }


}
