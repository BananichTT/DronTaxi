module com.mycompany.drontaxi {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.drontaxi to javafx.fxml;
    exports com.mycompany.drontaxi;
}
