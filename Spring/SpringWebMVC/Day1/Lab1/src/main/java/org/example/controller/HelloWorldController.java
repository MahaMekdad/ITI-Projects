package org.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloWorldController extends AbstractController{

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
        System.out.println("HERE!1");
        ModelAndView model = new ModelAndView("HelloWorldPage");
        model.addObject("msg", "Hello From HelloWorldController");
        System.out.println("HERE!2");
        return model;
    }
    
}
