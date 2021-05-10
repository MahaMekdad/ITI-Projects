package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ThreadedServer {
    public static ArrayList<Socket> sockets = new ArrayList<>();
    public static void main(String [] args){
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            int i = 1;
            while(true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("Number of multiClientsExample.Client Sockets: "+i);
                sockets.add(clientSocket);
                System.out.println("number of clients from server: " + sockets.size());
                Runnable runnable = new SocketThreadHandler(clientSocket);
                Thread thread = new Thread(runnable);
                thread.start();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

