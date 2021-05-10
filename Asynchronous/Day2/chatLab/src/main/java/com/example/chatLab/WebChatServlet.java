package com.example.chatLab;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;

//@WebServlet(name = "webChatServlet", value = "/webChatServlet")
@ServerEndpoint("/webChatServlet")
public class WebChatServlet{
    private final static Set<Session> users = new HashSet<>();
    private static Vector<Message> msgs = new Vector<>();

    @OnOpen
    public void onOpen(Session session){
        System.out.println(session.getId() + " sessionId");
        String queryString = session.getQueryString();
        System.out.println(queryString + " queryString");
        users.add(session);
        for (Message m: msgs) {
            try {
                session.getBasicRemote().sendText(buildGsonFromObject(m));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ArrayList<User> onlineUsers = new ArrayList<>();
        for (Session user: users) {
                User u = new User(getUserName(user.getQueryString()), "online", getGender(user.getQueryString()));
                onlineUsers.add(u);
        }
        try {
            session.getBasicRemote().sendText(buildGsonFromArrayObject(onlineUsers));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @OnMessage
    public void onMessage(String message, Session session){
        if(message.equals("getContacts")){
            System.out.println("inside the getContacts");
            ArrayList<User> onlineUsers = new ArrayList<>();
            for (Session user: users) {
                User u = new User(getUserName(user.getQueryString()), "online", getGender(user.getQueryString()));
                onlineUsers.add(u);
            }
            try {
                session.getBasicRemote().sendText(buildGsonFromArrayObject(onlineUsers));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("inside the onMessage");
            Message msg = new Message(session.getId(), getUserName(session.getQueryString()), getGender(session.getQueryString()), message);
            msgs.add(msg);
            for (Session s : users) {
                try {
                    s.getBasicRemote().sendText(buildGsonFromObject(msg));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private String buildGsonFromObject(Message msgs){
        Gson gsonMsg = new Gson();
        return gsonMsg.toJson(msgs);
    }

    private String buildGsonFromArrayObject(ArrayList<User> users){
        Gson gsonMsg = new Gson();
        return gsonMsg.toJson(users);
    }

    public String getUserName(String queryString){
        String [] params = queryString.split("&");
        return params[0].split("=")[1];
    }

    public String getGender(String queryString){
        String [] params = queryString.split("&");
        return params[1].split("=")[1];
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