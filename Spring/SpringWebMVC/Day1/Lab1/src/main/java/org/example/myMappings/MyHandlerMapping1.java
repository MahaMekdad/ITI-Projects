package org.example.myMappings;

import org.springframework.web.servlet.handler.AbstractDetectingUrlHandlerMapping;

public class MyHandlerMapping1 extends AbstractDetectingUrlHandlerMapping{

    @Override
    protected String[] determineUrlsForHandler(String controllerId) {
        String [] mappings = null;
        if(controllerId.equalsIgnoreCase("helloController")){
            mappings = new String[1];
            mappings[0] = "/welcome.htm";
            System.out.println("Here**");
        }
        return mappings;
    }
    
}
