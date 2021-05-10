package org.example;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.ui.controllers.ConnSocket;
import org.example.ui.helpers.StageCoordinator;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        StageCoordinator stageCoordinator = StageCoordinator.getInstance();
        stageCoordinator.initStage(primaryStage);
        stageCoordinator.switchToLoginScene();
        primaryStage.show();
        primaryStage.setOnCloseRequest(ae -> {
            try {
                ConnSocket.getInstance().close();
                System.out.println("hi");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void init() {
        // Initialize Database & Network Connections
    }

    @Override
    public void stop() {
        // Terminate Database & Network Connections
    }

    public static void main(String[] args) {
        launch();
    }

}