package org.example.demo;
import java.time.LocalDate;

public class Tarea {
    private int id;
    private String titulo;
    private String descripcion;
    private Prioridad prioridad;
    private LocalDate fechaLimite;

    public enum Prioridad {
        ALTA, MEDIA, BAJA
    }


}
