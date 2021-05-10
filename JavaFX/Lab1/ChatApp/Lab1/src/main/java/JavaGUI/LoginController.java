package JavaGUI;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class LoginController implements Initializable{

    @FXML
    private Button choosePic;
    @FXML
    private TextField nameTxtField;
    @FXML
    private ImageView imgView;
    @FXML
    private void switchToChat() throws IOException {
        if(nameTxtField.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Empty Input Fields");
            alert.setContentText("Please Enter Your Name");
            alert.showAndWait();
        }
        else {
            //App app = new App();
            //ChatController chatController = app.getController();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/JavaGUI/chat.fxml"));
            try {
                Parent root = (Parent) loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ChatController chatController = loader.getController();
            loader.setController(chatController);
            chatController.setUserNameAndPic(nameTxtField.getText(), imgView);
            nameTxtField.getScene().setRoot(loader.getRoot());
            //UserContext userContext = UserContext.getUserContext();
            //userContext.setUsername(nameTxtField.getText());
            //userContext.setUserImg();
            //username = nameTxtField.getText();
            //App.setRoot("chat");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choosePic.setOnAction(ae -> {
            FileChooser fileChooser = new FileChooser();
            Node source = (Node)ae.getSource();
            File selectedFile = fileChooser.showOpenDialog(source.getScene().getWindow());
            System.out.println(selectedFile.getPath());
            Image pp = new Image("/JavaGUI/images/m.jpg");
            imgView = new ImageView(pp);
            //System.out.println("PIC");
        });
    }
}
