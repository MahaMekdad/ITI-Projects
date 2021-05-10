package org.example.models;

import org.example.services.Service3;
import org.example.services.impls.Service4Impl;

public class Helper{

    
    public static Service3 createS4(){
        Service4Impl s4 = new Service4Impl();
        return s4;
    }
}