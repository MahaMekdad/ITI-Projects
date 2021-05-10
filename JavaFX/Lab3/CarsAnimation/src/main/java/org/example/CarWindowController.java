package org.example;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class CarWindowController implements Initializable {

    @FXML
    private Pane paneId;
//    @FXML
//    private Text statusId;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

            Node car = new ImageView(new Image(String.valueOf(getClass().getResource("/org/example/images/magnum.png"))));
            Node car2 = new ImageView(new Image(String.valueOf(getClass().getResource("/org/example/images/sonic.png"))));

            Path path = new Path();
            path.getElements().add(new MoveTo(146, 135));
            path.getElements().add(new HLineTo(228.8));
            path.getElements().add(new LineTo(376, 252));
            path.getElements().add(new HLineTo(489));
            ArcTo arcToI = new ArcTo(); arcToI.setX(485.6); arcToI.setY(135); arcToI.setRadiusX(60); arcToI.setRadiusY(60);
            path.getElements().add(arcToI);
            path.getElements().add(new HLineTo(371.2));
            path.getElements().add(new LineTo(230, 252.8));
            path.getElements().add(new HLineTo(120));
            path.setVisible(true);
            ArcTo arcToII = new ArcTo(); arcToII.setX(106); arcToII.setY(140); arcToII.setRadiusX(60); arcToII.setRadiusY(60);
            arcToII.setSweepFlag(true);
            path.getElements().add(arcToII);
            path.getElements().add(new ClosePath());
            path.setStrokeWidth(50);
            path.setStroke(Color.CORNFLOWERBLUE);

            Path path2 = new Path();
            path2.getElements().add(new MoveTo(146, 135));
            path2.getElements().add(new HLineTo(228.8));
            path2.getElements().add(new LineTo(376, 252));
            path2.getElements().add(new HLineTo(489));
            ArcTo arcToI2 = new ArcTo(); arcToI2.setX(485.6); arcToI2.setY(135); arcToI2.setRadiusX(60); arcToI2.setRadiusY(60);
            path2.getElements().add(arcToI2);
            path2.getElements().add(new HLineTo(371.2));
            path2.getElements().add(new LineTo(230, 252.8));
            path2.getElements().add(new HLineTo(120));
            path2.setVisible(true);
            ArcTo arcToII2 = new ArcTo(); arcToII2.setX(106); arcToII2.setY(140); arcToII2.setRadiusX(60); arcToII2.setRadiusY(60);
            arcToII2.setSweepFlag(true);
            path2.getElements().add(arcToII2);
            path2.getElements().add(new ClosePath());
            path2.getStrokeDashArray().addAll(10.0,10.0);

            PathTransition pathTransition = new PathTransition();
            pathTransition.setDuration(Duration.seconds(15));
            pathTransition.setPath(path);
            pathTransition.setNode(car);
            pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
            pathTransition.setCycleCount(Timeline.INDEFINITE);
            pathTransition.play();

            PathTransition pathTransition2 = new PathTransition();
            pathTransition2.setDuration(Duration.seconds(20));
            pathTransition2.setPath(path);
            pathTransition2.setNode(car2);
            pathTransition2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
            pathTransition2.setCycleCount(Timeline.INDEFINITE);
            pathTransition2.play();

            paneId.getChildren().addAll(path, path2, car, car2);

            car.setOnMouseClicked(ae ->{
                if(ae.getClickCount() == 2)
                    reverseDirections(pathTransition);
                else if (ae.getClickCount() == 1){
                    File resource = new File("src/main/resources/org/example/audios/car-honk.wav");
                    AudioClip honk = new AudioClip(resource.toURI().toString());
                    honk.play();
                }
            });
            car2.setOnMouseClicked(ae ->{
                if(ae.getClickCount() == 2)
                    reverseDirections(pathTransition2);
                else if (ae.getClickCount() == 1){
                    File resource = new File("src/main/resources/org/example/audios/car-honk.wav");
                    AudioClip honk = new AudioClip(resource.toURI().toString());
                    honk.play();
                }
            });

    }

    private void reverseDirections(PathTransition pt){
        if(pt.getRate() < 0)
            pt.setRate(1.0);
        else
            pt.setRate(-1.0);
    }
//    @FXML
//    private void displayPosition(MouseEvent event){
//        statusId.setText("X = " + event.getX() + " Y = " + event.getY());
//    }
}
