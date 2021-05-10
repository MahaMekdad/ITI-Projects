package com.example.chatLab;

import java.io.*;
import java.util.*;

import com.google.gson.Gson;
import jakarta.json.JsonObject;
import jakarta.mail.MessageAware;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import org.json.JSONObject;

//@WebServlet(name = "webChatServlet", value = "/webChatServlet")
@WebServlet(name = "webChatServlet", value = "/webChatServlet")
public class WebChatServlet extends HttpServlet{
   // private final static Set<User> users = new HashSet<>();
   private final static List<User> users = new ArrayList<>();
    private static Vector<Message> msgs = new Vector<>();


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data = request.getParameter("data");
        System.out.println("HERE1 " + data);
        String name = request.getParameter("name");
        System.out.println("HERE2 " + name);
        if(data != null){
            JSONObject obj = new JSONObject(data);
            String message = obj.getString("msg");
            String username = obj.getString("name");
            String gender = obj.getString("gender");
            System.out.println(obj.getString("msg") + " " + obj.getString("name") + " " + obj.getString("gender"));
            System.out.println(data + " ------>");
            if (message != null && !message.trim().equals("") && username != null && gender != null) {
                Message msg = new Message(username, gender, message);
                msgs.add(msg);
                //User u = new User(username, "online", gender);
                //users.add(u);
            }
        } else if(name != null){
            int index = 0;
            JSONObject obj = new JSONObject(name);
            String username = obj.getString("username");
            System.out.println("HERE3 " + username);
            for (User user: users) {
                if(user.name.equals(username)){
                    System.out.println("HERE4 " + user.name);
                    System.out.println("HERE5 " + username);
                    index = users.indexOf(user);
                    break;
                }
            }
            users.remove(index);
            System.out.println("HERE6 out");
        }
        System.out.println("HERE7 after the logic");
        PrintWriter out = response.getWriter();
        out.write("Done!");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        goAddTheUser(request);
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        int msgId = 0;
        String lastId = request.getHeader("Last-Event-ID");
        //System.out.println(lastId+"-->lastId");
        //System.out.println(msgs.size()+"--->msgsize");
        if (lastId != null) {
            msgId = Integer.parseInt(lastId);
            if (!msgs.isEmpty()) {
                ArrayList<Message> msgsList = new ArrayList<>();
                for (int i = msgId; i < msgs.size(); i++) {
                    msgsList.add(msgs.get(i));
                }
                out.write("data: " +  buildGsonFromArrayObject(msgsList) + "\n");
                msgId= msgs.size();
                out.write("id: " + msgId + "\n\n");
                out.flush();
            }
            out.write("data: " +  buildGsonFromSetObject(users) + "\n");
            out.write("event: userstatus" + "\n\n");
            out.flush();
        } else {
            //System.out.println("here in the null else of msg id");
            out.print("id: " + msgId + "\n\n");
            out.flush();
            out.close();
        }
    }

    private void goAddTheUser(HttpServletRequest request) {
        boolean flag = false;
        String username = request.getParameter("name");
        String gender = request.getParameter("gender");
        if (username != null && gender != null) {
            User comingUser = new User(username, "online", gender);
            //System.out.println("inside go add user loop " + users.size());
            if(users.size()==0)
            {
                users.add(comingUser);
            }else
            {
                for(int i = 0 ; i <users.size();i++)
                {
                    if(users.get(i).name.equals(comingUser.name))
                    {
                        flag = true;
                        break;
                    }
                }
                if(flag==false)
                {
                    users.add(comingUser);
                }
            }
        }
    }

    private String buildGsonFromSetObject(List<User> users){
        Gson gsonMsg = new Gson();
        return gsonMsg.toJson(users);
    }

    private String buildGsonFromArrayObject(ArrayList<Message> msgs){
        Gson gsonMsg = new Gson();
        return gsonMsg.toJson(msgs);
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("inside the close");
        //before inform the users to remove him/her
        users.remove(session);
//        for (Session user: users) {
//            try {
//                User u = new User(getUserName(user.getQueryString()), "online");
//                session.getBasicRemote().sendText(buildGsonFromUserObject(u));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }
}