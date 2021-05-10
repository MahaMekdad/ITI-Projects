package org.example.ui.helpers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class SceneData {

    private final FXMLLoader fxmlLoader;
    private final Parent view;
    private final Scene scene;

    public SceneData(FXMLLoader fxmlLoader, Parent view, Scene scene){
        this.fxmlLoader = fxmlLoader;
        this.view = view;
        this.scene = scene;
    }

    public FXMLLoader getLoader(){
        return fxmlLoader;
    }

    public Parent getParent(){
        return view;
    }

    public Scene getScene(){
        return scene;
    }
}
