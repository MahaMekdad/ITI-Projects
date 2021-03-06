package com.pluralsight.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    // injecting our custom properties
    @Value("${app.description}")
    private String appDescription;

    @Value("${app.version}")
    private String appVersion;

    @GetMapping
    @RequestMapping("/")
    public Map getStatus(){
        Map<String, String> map = new HashMap<>();
        map.put("app-description", appDescription);
        map.put("app-version", appVersion);
        return map;
    }
}
