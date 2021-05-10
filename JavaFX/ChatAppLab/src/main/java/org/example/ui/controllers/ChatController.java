package org.example.ui.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import org.example.ThreadedServer;
import org.example.ui.helpers.ModelsFactory;
import org.example.ui.models.UserModel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ChatController implements Initializable {

    @FXML
    private Label nameLabel;
    @FXML
    private TextField textField;
    @FXML
    private VBox vContentArea;
    @FXML
    private ImageView userPic;
    @FXML
    private ScrollPane scrollId;

    public void initialize(URL location, ResourceBundle resources) {
        ModelsFactory modelsFactory = ModelsFactory.getInstance();
        UserModel currentUserModel = modelsFactory.getCurrentUserModel();

        nameLabel.textProperty().bindBidirectional(currentUserModel.usernameProperty());
        Socket socket = null;
        try {
            socket = ConnSocket.getInstance();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread t = new ReadingFromServer(socket);
        t.start();
    }

    public void handleSendBtn(ActionEvent actionEvent) throws IOException {
        //System.out.println("number of clients from send button: " + ThreadedServer.sockets.size());
        Socket socket = ConnSocket.getInstance();
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream, true);
        //String [] userInfo = {textField.getText(), nameLabel.getText()};
        out.println(textField.getText());

    }

    public void msgComponent(String msg){
        //scrollId.vvalueProperty().bind(vContentArea.heightProperty());
        ImageView imgV = new ImageView(userPic.getImage());
        imgV.setFitHeight(30); imgV.setFitWidth(30);

        Label userNameLabel = new Label(nameLabel.getText());
        Label userPicLabel = new Label(); userPicLabel.setGraphic(imgV);
        //Label textMsg = new Label(textField.getText());
        Label textMsg = new Label(msg);
        textMsg.setWrapText(true);
        textField.setText("");

        textMsg.setStyle("-fx-background-color: #ABC8E2; -fx-background-radius: 5px");
        textMsg.setMaxWidth(vContentArea.getMaxWidth());
        textMsg.setPrefSize(Region.USE_COMPUTED_SIZE,Region.USE_COMPUTED_SIZE);
        textMsg.setPrefHeight(Region.USE_COMPUTED_SIZE);
        textMsg.setPrefWidth(Region.USE_COMPUTED_SIZE);

        BorderPane txtImgBPane = new BorderPane();
        txtImgBPane.setMaxWidth(vContentArea.getMaxWidth());
        txtImgBPane.setLeft(userPicLabel); txtImgBPane.setCenter(textMsg);
        txtImgBPane.setPrefHeight(Region.USE_COMPUTED_SIZE);
        txtImgBPane.setPrefWidth(Region.USE_COMPUTED_SIZE);

        HBox hBox1 = new HBox();
        hBox1.getChildren().add(userNameLabel);
        hBox1.setAlignment(Pos.TOP_LEFT);
        hBox1.setPrefSize(Region.USE_COMPUTED_SIZE,Region.USE_COMPUTED_SIZE);
        hBox1.setMaxWidth(vContentArea.getMaxWidth());

        HBox hBox2 = new HBox();
        hBox2.getChildren().add(txtImgBPane);
        hBox2.setAlignment(Pos.TOP_LEFT);
        hBox2.setPrefSize(Region.USE_COMPUTED_SIZE,Region.USE_COMPUTED_SIZE);
        hBox2.setMaxWidth(vContentArea.getPrefWidth());
        //vContentArea.getChildren().addAll(hBox1, hBox2);
        vContentArea.getChildren().addAll(hBox2);
        vContentArea.setSpacing(10);
    }

    //Thread for reading from server on its own!!!
    private class ReadingFromServer extends Thread{
        private Socket server;
        private String msg;
        private String name;
        public ReadingFromServer(Socket server){
            this.server = server;
        }
        public void run(){
            InputStream inputStream = null;
            OutputStream outputStream = null;
            try {
                inputStream = server.getInputStream();
                outputStream = server.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Scanner in = new Scanner(inputStream);
            while(true){
                if(in.hasNextLine()){
                    this.msg = in.nextLine();
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            msgComponent(msg);
                        }
                    });
                }
            }
        }
    }
}
