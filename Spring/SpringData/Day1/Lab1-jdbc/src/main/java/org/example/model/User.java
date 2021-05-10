package org.example.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import lombok.Data;

@Data
public class User {
    String username;
    String password;
    int age;

    public User(){}

    public User(String n, String p, int a){
        username = n;
        password = p;
        age = a;
    }

    public String toString(){
        return this.username + ", " + this.password + ", " + this.age;
    }
}
