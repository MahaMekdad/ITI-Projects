package JavaGUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class ChatController implements Initializable {

    @FXML
    private TextField textField;
    @FXML
    private Label nameLabel;
    @FXML
    private ImageView userPic;
    @FXML
    private VBox vContentArea;

    public ChatController() throws IOException {
    }

    /*private void switchToLogin() throws IOException {
        App.setRoot("login");
    }*/

    public void setUserNameAndPic(String name, ImageView pic){
        nameLabel.setText(name);
        userPic = pic;
        userPic.setFitHeight(30); userPic.setFitWidth(30);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ActionEvent) {
                ImageView imgV = new ImageView(userPic.getImage());
                imgV.setFitWidth(30); imgV.setFitHeight(30);
                Label userNameLabel = new Label(nameLabel.getText());
                Label userPicLabel = new Label(); userPicLabel.setGraphic(imgV);

                Label textMsg = new Label(textField.getText());
                textMsg.setStyle("-fx-background-color: yellow;");
                textMsg.setWrapText(true); textMsg.setMaxWidth(vContentArea.getMaxWidth());
                textMsg.setPrefSize(Region.USE_COMPUTED_SIZE,Region.USE_COMPUTED_SIZE);
                textMsg.setPrefHeight(Region.USE_COMPUTED_SIZE);
                textMsg.setPrefWidth(Region.USE_COMPUTED_SIZE);
                BorderPane txtImgBPane = new BorderPane();
                txtImgBPane.setMaxWidth(vContentArea.getMaxWidth());
                txtImgBPane.setLeft(userPicLabel); txtImgBPane.setCenter(textMsg);
                txtImgBPane.setPrefHeight(Region.USE_COMPUTED_SIZE);
                txtImgBPane.setPrefWidth(Region.USE_COMPUTED_SIZE);

                TextArea txt = new TextArea(textField.getText());
                //txt.setEditable(false);
                //txt.setWrapText(true);
                //txt.setPrefSize(500,100);
                //textMsg.textOverrunProperty().set(OverrunStyle.CLIP);
                //Pane txtImgPane = new Pane(); txtImgPane.getChildren().addAll(userPicLabel, textMsg);
                textField.setText("");


                HBox hBox1 = new HBox();
                hBox1.getChildren().add(userNameLabel);
                hBox1.setAlignment(Pos.TOP_LEFT);
                hBox1.setPrefSize(Region.USE_COMPUTED_SIZE,Region.USE_COMPUTED_SIZE);
                hBox1.setMaxWidth(vContentArea.getMaxWidth());
                HBox hBox2 = new HBox();
                hBox2.getChildren().add(txtImgBPane);
                hBox2.setAlignment(Pos.TOP_LEFT);
                hBox2.setPrefSize(Region.USE_COMPUTED_SIZE,Region.USE_COMPUTED_SIZE);
                hBox2.setMaxWidth(vContentArea.getMaxWidth());
                vContentArea.getChildren().addAll(hBox1, hBox2);
                vContentArea.setSpacing(6);
            }
        });
    }
}