module com.example.airlineticketmanagementsys {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.airlineticketmanagementsys to javafx.fxml;
    exports com.example.airlineticketmanagementsys;
}