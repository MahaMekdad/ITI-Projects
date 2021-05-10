package org.example.ui.controllers;

import org.example.ThreadedServer;

import java.io.IOException;
import java.net.Socket;

public class ConnSocket {

    private static Socket socket = null;

    private ConnSocket(){}

    public static synchronized Socket getInstance() throws IOException {
        if(socket == null){
            socket = new Socket("localhost", 8000);

            //System.out.println("number of clients: " + ThreadedServer.sockets.size());
        }
        return socket;
    }
}
