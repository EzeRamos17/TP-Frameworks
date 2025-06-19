package ramos.utilizacion;

import ramos.framework.Accion;
import java.util.Scanner;

public class AccionPalindromo implements Accion {
    @Override
    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese una palabra o frase: ");
        String texto = scanner.nextLine();
        String limpio = texto.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String invertido = new StringBuilder(limpio).reverse().toString();
        if (limpio.equals(invertido)) {
            System.out.println("¡Es un palíndromo!");
        } else {
            System.out.println("No es un palíndromo.");
        }
    }

    @Override
    public String nombreItemMenu() {
        return "Verificar palíndromo";
    }

    @Override
    public String descripcionItemMenu() {
        return "Verifica si una palabra o frase es un palíndromo";
    }
} 