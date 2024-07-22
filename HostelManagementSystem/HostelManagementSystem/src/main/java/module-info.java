module org.example.procode {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.procode to javafx.fxml;
    exports org.example.procode;
}