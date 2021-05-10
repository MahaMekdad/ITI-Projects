package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        music();
        stage.setTitle("Car Animation Lab");
        Parent root = FXMLLoader.load(getClass().getResource("carWindow.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    MediaPlayer mediaPlayer;
    public void music() {
        File bgResource = new File("src/main/resources/org/example/audios/Lets-Go-Spacetoon.mp3");
        Media media = new Media(bgResource.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.play();
    }

    public static void main(String[] args) {
        launch();
    }

}