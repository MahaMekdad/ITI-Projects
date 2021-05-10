package com.example.chatLab;

public class Message {
    public String sessionId;
    public String sender;
    public String gender;
    public String msg;

    public Message(String id, String sender, String gender, String msg){
        this.sessionId = id;
        this.sender = sender;
        this.gender = gender;
        this.msg = msg;
    }
}
