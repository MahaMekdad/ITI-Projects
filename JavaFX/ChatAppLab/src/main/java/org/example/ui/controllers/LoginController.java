package org.example.ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import org.example.ui.helpers.ModelsFactory;
import org.example.ui.helpers.StageCoordinator;
import org.example.ui.models.UserModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button choosePicBtn;
    @FXML
    private TextField nameTxtField;
    @FXML
    private TextField passwordTxtField;
    @FXML
    private ImageView imgView;
    @FXML
    private Button vamosBtn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ModelsFactory modelsFactory = ModelsFactory.getInstance();
        UserModel currentUserModel = modelsFactory.getCurrentUserModel();

        nameTxtField.textProperty().bindBidirectional(currentUserModel.usernameProperty());
        passwordTxtField.textProperty().bindBidirectional(currentUserModel.passwordProperty());
    }

    public void handleLogin(ActionEvent actionEvent) {
        try {
            Socket clientSocket = ConnSocket.getInstance();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StageCoordinator stageCoordinator = StageCoordinator.getInstance();
        stageCoordinator.switchToChatScene();
    }

    public void choosePicHandle(ActionEvent actionEvent){
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        if(selectedFile != null){
            try{
                FileInputStream fileInputStream = new FileInputStream(selectedFile.getAbsoluteFile());
                imgView.setImage(new Image(fileInputStream));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
