module com.example.crudkrs {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.crudkrs to javafx.fxml;
    exports com.example.crudkrs;
}