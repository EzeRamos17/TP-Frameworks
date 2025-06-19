package ramos.utilizacion;

import ramos.framework.Accion;
import java.util.Scanner;

public class AccionMultiplicar implements Accion {
    @Override
    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el primer número: ");
        int a = scanner.nextInt();
        System.out.print("Ingrese el segundo número: ");
        int b = scanner.nextInt();
        System.out.println("El producto es: " + (a * b));
        scanner.nextLine(); // Limpiar buffer
    }

    @Override
    public String nombreItemMenu() {
        return "Multiplicar dos números";
    }

    @Override
    public String descripcionItemMenu() {
        return "Pide dos números y muestra el producto";
    }
} 