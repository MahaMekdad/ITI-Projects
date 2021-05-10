package org.example.ui.helpers;

import org.example.ui.models.UserModel;

public class ModelsFactory {

    private static final ModelsFactory instance = new ModelsFactory();

    private UserModel currentUserModel;

    private ModelsFactory() {};

    public static ModelsFactory getInstance(){
        return instance;
    }

    public UserModel getCurrentUserModel(){
        if(currentUserModel == null){
            currentUserModel = new UserModel();
        }
        return  currentUserModel;
    }



}
