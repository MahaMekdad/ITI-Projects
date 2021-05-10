package org.example.models;

import org.example.daos.Dao1;

public class TestService {

    private Dao1 dao1;

    public void setDao1(Dao1 dao1){
        System.out.println("hello from the setter of the TestService class that sets the doa1 var");
        this.dao1 = dao1;
    }
    
}
