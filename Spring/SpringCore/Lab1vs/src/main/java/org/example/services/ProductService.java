package org.example.services;

import org.example.daos.Dao1;

public class ProductService {
    
    Dao1 dao1;

    public void setDao1(Dao1 dao1){
        System.out.println("inside the setter of the setDao1(Dao1 dao1) of UserService");
        this.dao1 = dao1;
    }

    public Dao1 getDao1(){
        System.out.println("inside the getter of the getDao1() of UserService");
        return this.dao1;
    }
}
