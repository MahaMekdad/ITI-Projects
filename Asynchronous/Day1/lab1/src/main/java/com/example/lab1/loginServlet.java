package com.example.lab1;
import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class loginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("inside the servlet");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        System.out.println("inside the servlet before");
        String un = request.getParameter("un");
        System.out.println("name is " + un);
        System.out.println("inside the servlet after");
        if(un.equalsIgnoreCase("mahamekdad")){
            System.out.println("here and correct");
            out.println("Valid Username");
        } else {
            System.out.println("here and incorrect");
            out.println("Invalid Username");
        }
        out.close();
    }
}