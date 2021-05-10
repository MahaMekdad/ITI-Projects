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
    private int id;

    // @Min(value = 3, message = "NAME MUST BE 3 CHARACTERS MINIMUM")
    // @Min(3)
    @Size(min=3 ,message = "NAME MUST BE 3 CHARACTERS OR MORE")
    private String name;

    // @Pattern(regexp = "^[0-9]+$")
    private int age;
    
    @NotEmpty(message = "PHONE MUST NOT BE EMPTY")
    // @Max(value = 11, message = "PHONE MUST NOT BE 11 DIGITS")
    @Size(max=11 ,message = "PHONE MUST NOT BE MORE THAN 11 DIGITS")
    private String phone;

    @Email(message = "NOT A VALID EMAIL FORMAT")
    private String email;

    public User(int id, String name, int age, String phone, String email){
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public User() {
    }
}
