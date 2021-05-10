module JavaGUI {
    requires javafx.controls;
    requires javafx.fxml;

    opens JavaGUI to javafx.fxml;
    exports JavaGUI;
}