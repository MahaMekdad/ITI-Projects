package JavaGUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    /*public Object getController(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/JavaGUI/chat.fxml"));
        try {
            Parent root = (Parent) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ChatController chatController = loader.getController();
        loader.setController(chatController);
        return chatController;
        //chatController.setUserNameAndPic(nameTxtField.getText(), imgView);
    }*/

    /*static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }*/

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}