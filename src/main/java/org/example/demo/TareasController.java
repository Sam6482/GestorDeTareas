package org.example.demo;

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

    private ObservableList<Tarea> listaTareas = FXCollections.observableArrayList();
    private int siguienteId = 1;

    @FXML
    public void initialize() {
        // Configurar tabla
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colPrioridad.setCellValueFactory(new PropertyValueFactory<>("prioridad"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaLimite"));
        tablaTareas.setItems(listaTareas);

        // Configurar ComboBox
        cbxPrioridad.getItems().addAll(Tarea.Prioridad.values());

        // Selección de tabla
        tablaTareas.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> cargarTareaSeleccionada(newSelection));
    }

    private void cargarTareaSeleccionada(Tarea tarea) {
        if (tarea != null) {
            txtTitulo.setText(tarea.getTitulo());
            txtDescripcion.setText(tarea.getDescripcion());
            cbxPrioridad.setValue(tarea.getPrioridad());
            dtpFechaLimite.setValue(tarea.getFechaLimite());
        }
    }

    private void limpiarCampos() {
        txtTitulo.clear();
        txtDescripcion.clear();
        cbxPrioridad.getSelectionModel().clearSelection();
        dtpFechaLimite.setValue(null);
        tablaTareas.getSelectionModel().clearSelection();
    }

    private boolean validarCampos() {
        if (txtTitulo.getText().isEmpty() ||
                txtDescripcion.getText().isEmpty() ||
                cbxPrioridad.getValue() == null ||
                dtpFechaLimite.getValue() == null) {

            mostrarAlerta("Error", "Todos los campos son obligatorios");
            return false;
        }
        return true;
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    private void agregarTarea() {
        if (validarCampos()) {
            Tarea nuevaTarea = new Tarea(
                    siguienteId++,
                    txtTitulo.getText(),
                    txtDescripcion.getText(),
                    cbxPrioridad.getValue(),
                    dtpFechaLimite.getValue()
            );
            listaTareas.add(nuevaTarea);
            limpiarCampos();
        }
    }

    @FXML
    private void editarTarea() {
        Tarea tareaSeleccionada = tablaTareas.getSelectionModel().getSelectedItem();
        if (tareaSeleccionada != null) {
            if (validarCampos()) {
                tareaSeleccionada.setTitulo(txtTitulo.getText());
                tareaSeleccionada.setDescripcion(txtDescripcion.getText());
                tareaSeleccionada.setPrioridad(cbxPrioridad.getValue());
                tareaSeleccionada.setFechaLimite(dtpFechaLimite.getValue());

                tablaTareas.refresh();
                limpiarCampos();
            }
        } else {
            mostrarAlerta("Error", "Seleccione una tarea para editar");
        }
    }

    @FXML
    private void eliminarTarea() {
        Tarea tareaSeleccionada = tablaTareas.getSelectionModel().getSelectedItem();
        if (tareaSeleccionada != null) {
            listaTareas.remove(tareaSeleccionada);
            limpiarCampos();
        } else {
            mostrarAlerta("Error", "Seleccione una tarea para eliminar");
        }
    }

}
