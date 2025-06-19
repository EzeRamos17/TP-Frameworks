package ramos.utilizacion;

import ramos.framework.Accion;
import java.util.Scanner;

public class AccionSumar implements Accion {
    @Override
    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el primer número: ");
        int a = scanner.nextInt();
        System.out.print("Ingrese el segundo número: ");
        int b = scanner.nextInt();
        System.out.println("La suma es: " + (a + b));
        scanner.nextLine();
    }

    @Override
    public String nombreItemMenu() {
        return "Sumar dos números";
    }

    @Override
    public String descripcionItemMenu() {
        return "Pide dos números y muestra la suma";
    }
} 