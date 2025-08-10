package org.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    static {
        System.setProperty("javafx.verbose", "true");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Usa getResource con ruta absoluta en el classpath
        Parent root = FXMLLoader.load(getClass().getResource("/org/example/demo/tareas.fxml"));
        primaryStage.setTitle("Gestión de Tareas");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}