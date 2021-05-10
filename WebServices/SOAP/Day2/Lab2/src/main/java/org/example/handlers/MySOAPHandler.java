package org.example.handlers;
import jakarta.xml.ws.handler.soap.*;
import java.util.*;
import jakarta.xml.ws.handler.MessageContext;
import javax.xml.namespace.QName;

public class MySOAPHandler implements SOAPHandler<SOAPMessageContext>{
    @Override
    public Set<QName> getHeaders(){
        System.out.println("getHeaders--> ");
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext arg0){
        System.out.println("handleMessage--> " + arg0);
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext arg0){
        System.out.println("handleFault--> " + arg0);
        return true;
    }

    @Override
    public void close(MessageContext arg0){
        System.out.println("close--> " + arg0);
    }
}