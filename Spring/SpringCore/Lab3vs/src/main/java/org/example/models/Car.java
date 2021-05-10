package org.example.models;

import org.springframework.beans.factory.annotation.Required;

public class Car {
    private Engine engine;

    @Required
    public void setEngine(Engine engine){
        this.engine = engine;
        System.out.println(this + " <-------Car");
    }

    public Engine getEngine(){
        return this.engine;
    }


}
