package org.example;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class SocketThreadHandler implements Runnable{
    private Socket socket;

    public SocketThreadHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try(InputStream inputStream = socket.getInputStream(); OutputStream outputStream = socket.getOutputStream();) {
            Scanner in = new Scanner(inputStream, "UTF-8");
            //ObjectInputStream inn = new ObjectInputStream(inputStream);
            //PrintWriter out = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);
            System.out.println("Hi from server thread");
            while(true && (socket.isClosed() == false)){
                System.out.println("blocking mood");
                //System.out.println(in.nextLine() + "555555");
                if(in.hasNextLine()){
                    String msg = in.nextLine();
                    sendToAll(ThreadedServer.sockets, msg);
                    System.out.println("HERE in Server run thread");
                }
                //out.println("Server Echo: "+line);
                System.out.println("Hi from server thread inside the while true");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendToAll(ArrayList<Socket> clients, String msg){
        PrintWriter pw;
        for (Socket client : clients) {
            try {
                pw = new PrintWriter(new OutputStreamWriter(client.getOutputStream(), "UTF-8"), true);
                pw.println(msg);
                //System.out.println("HERE in SendToAll method");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

