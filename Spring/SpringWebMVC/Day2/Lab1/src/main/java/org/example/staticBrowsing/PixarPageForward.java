package org.example.staticBrowsing;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.mvc.AbstractUrlViewController;
import org.springframework.web.util.UrlPathHelper;

public class PixarPageForward extends AbstractUrlViewController{

    @Override
    protected String getViewNameForRequest(HttpServletRequest arg0) {
        String viewName = null;
        String requestPath = new UrlPathHelper().getPathWithinApplication(arg0);
        System.out.println(requestPath + "<---------");
        if(requestPath.equals("/pixar2")){
            viewName = "pixar2";
        }
        return viewName;
    }
    
}
