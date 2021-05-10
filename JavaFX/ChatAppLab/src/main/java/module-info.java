module org.example {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;

//    opens org.example to javafx.fxml;
    opens org.example.ui.controllers to javafx.fxml;
    exports org.example;
}