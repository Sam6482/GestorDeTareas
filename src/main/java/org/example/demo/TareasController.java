package org.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDate;

public class TareasController {
    @FXML private TableView<Tarea> tablaTareas;
    @FXML private TableColumn<Tarea, Integer> colId;
    @FXML private TableColumn<Tarea, String> colTitulo;
    @FXML private TableColumn<Tarea, String> colDescripcion;
    @FXML private TableColumn<Tarea, String> colPrioridad;
    @FXML private TableColumn<Tarea, LocalDate> colFecha;

    @FXML private TextField txtTitulo;
    @FXML private TextArea txtDescripcion;
    @FXML private ComboBox<Tarea.Prioridad> cbxPrioridad;
    @FXML private DatePicker dtpFechaLimite;
    @FXML

    private ObservableList<Tarea> listaTareas = FXCollections.observableArrayList();
    private int siguienteId = 1;
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}