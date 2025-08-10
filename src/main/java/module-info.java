module org.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    // Abre tu paquete a javafx.fxml
    opens org.example.demo to javafx.fxml;

    // Exporta tu paquete principal
    exports org.example.demo;
}