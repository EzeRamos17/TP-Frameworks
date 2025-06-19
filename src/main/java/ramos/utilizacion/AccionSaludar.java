package ramos.utilizacion;

import ramos.framework.Accion;
import java.util.Scanner;

public class AccionSaludar implements Accion {
    @Override
    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("¿Cómo te llamas? ");
        String nombre = scanner.nextLine();
        System.out.println("¡Hola, " + nombre + "!");
    }

    @Override
    public String nombreItemMenu() {
        return "Saludar";
    }

    @Override
    public String descripcionItemMenu() {
        return "Pide tu nombre y te saluda";
    }
} 