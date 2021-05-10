package org.example.handlers;
import jakarta.xml.ws.handler.LogicalHandler;
import jakarta.xml.ws.handler.MessageContext;
import jakarta.xml.ws.handler.LogicalMessageContext;

public class MyLogicalHandler implements LogicalHandler<LogicalMessageContext> {

    @Override
    public boolean handleMessage(LogicalMessageContext arg0){
        System.out.println("handleMessage--> " + arg0);
        return true;
    }

    @Override
    public boolean handleFault(LogicalMessageContext arg0){
        System.out.println("handleFault--> " + arg0);
        return true;
    }

    @Override
    public void close(MessageContext arg0){
        System.out.println("close--> " + arg0);
    }
}