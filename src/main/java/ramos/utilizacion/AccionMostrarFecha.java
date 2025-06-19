package ramos.utilizacion;

import ramos.framework.Accion;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AccionMostrarFecha implements Accion {
    @Override
    public void ejecutar() {
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println("Fecha y hora actual: " + ahora.format(formatter));
    }

    @Override
    public String nombreItemMenu() {
        return "Mostrar fecha y hora";
    }

    @Override
    public String descripcionItemMenu() {
        return "Muestra la fecha y hora actual";
    }
} 