module org.example.mus {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.mus to javafx.fxml;
    exports org.example.mus;
}