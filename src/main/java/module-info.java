module com.mycompany.drontaxi {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires java.base;
    requires java.xml.bind;

    opens com.mycompany.drontaxi to javafx.fxml;
    exports com.mycompany.drontaxi;
    opens com.mycompany.drontaxi.db;
}
