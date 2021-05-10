package org.example;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;

public class ClientSalma {

    private static Client ClientSalmaInstance = null;

    public static Client getInstance() {
        if (ClientSalmaInstance == null) {
            synchronized (ClientSalma.class) {
                if (ClientSalmaInstance == null) {
                    ClientSalmaInstance = ClientBuilder.newClient();
                }
            }
        }
        return ClientSalmaInstance;
    }
    
}
