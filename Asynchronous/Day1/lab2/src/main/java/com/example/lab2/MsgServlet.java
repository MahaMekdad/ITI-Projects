package com.example.lab2;

import java.io.*;
import java.util.Vector;

import com.google.gson.Gson;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "msgServlet", value = "/msgServlet")
public class MsgServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        ServletContext sc = request.getServletContext();
//        Integer counter =(Integer) sc.getAttribute("counter");
//        System.out.println(counter + " before");
        String name = request.getParameter("name");
        String msg = request.getParameter("msg");
        String counter = request.getParameter("c");
        Message msgObj = new Message(name, msg);
        Vector<Message> msgs = helper(request);
        msgs.add(msgObj);
        PrintWriter out = response.getWriter();
        out.println("success");
        //out.println(buildGsonFromObject(getSpecificMsgs(counter, msgs)));
//        counter += 1;
//        System.out.println(counter + " after");
//        sc.setAttribute("counter", counter);
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        ServletContext sc = request.getServletContext();
//        Integer counter = (Integer) sc.getAttribute("counter");
        String counter = request.getParameter("c");
        System.out.println(counter + " ----->");
        Vector<Message> msgs = helper(request);
        if(!msgs.isEmpty()){
            //System.out.println(" ----->");
            out.println(buildGsonFromObject(getSpecificMsgs(Integer.parseInt(counter), msgs)));
            out.close();
        }
    }

    private Vector helper(HttpServletRequest request){
        ServletContext sc = request.getServletContext();
        Vector<Message> msgs = (Vector<Message>) sc.getAttribute("vMsgs");
        if(msgs != null){
            return msgs;
        } else {
            Vector<Message> msgsNew = new Vector<>();
            sc.setAttribute("vMsgs", msgsNew);
            return msgsNew;
        }
    }

    private Vector getSpecificMsgs(int counter, Vector<Message> msgs){
        Vector<Message> specific = new Vector<>();
        for(int i = counter; i < msgs.size(); i++){
            //System.out.println(i + ": i " + msgs.size() + ": size");
            //System.out.println(msgs.get(i).name);
            specific.add(msgs.get(i));
        }
        return specific;
    }

    private String buildGsonFromObject(Vector<Message> msgs){
        Gson gsonMsg = new Gson();
        return gsonMsg.toJson(msgs);
    }
}