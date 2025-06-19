package ramos.utilizacion;

import ramos.framework.Accion;
import java.util.Scanner;

public class AccionContarHastaN implements Accion {
    @Override
    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número: ");
        int n = scanner.nextInt();
        System.out.print("Conteo: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        scanner.nextLine();
    }

    @Override
    public String nombreItemMenu() {
        return "Contar hasta N";
    }

    @Override
    public String descripcionItemMenu() {
        return "Cuenta desde 1 hasta el número ingresado";
    }
} 