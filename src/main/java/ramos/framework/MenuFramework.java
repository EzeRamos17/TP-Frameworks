package ramos.framework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuFramework {
    private List<Accion> acciones = new ArrayList<>();

    // Carga las acciones desde el archivo de configuración
    public void cargarAcciones(String pathConfig) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(pathConfig))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (!linea.isEmpty()) {
                    try {
                        Class<?> clazz = Class.forName(linea);
                        Accion accion = (Accion) clazz.getDeclaredConstructor().newInstance();
                        acciones.add(accion);
                    } catch (Exception e) {
                        System.out.println("No se pudo cargar la acción: " + linea + " (" + e.getMessage() + ")");
                    }
                }
            }
        }
    }

    // Muestra el menú y gestiona el ciclo principal
    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== MENÚ ===");
            for (int i = 0; i < acciones.size(); i++) {
                Accion accion = acciones.get(i);
                System.out.printf("%d. %s - %s\n", i + 1, accion.nombreItemMenu(), accion.descripcionItemMenu());
            }
            System.out.printf("%d. Salir\n", acciones.size() + 1);
            System.out.print("Seleccione una opción: ");
            String input = scanner.nextLine();
            int opcion;
            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida. Intente de nuevo.");
                continue;
            }
            if (opcion == acciones.size() + 1) {
                System.out.println("¡Hasta luego!");
                break;
            } else if (opcion >= 1 && opcion <= acciones.size()) {
                Accion accion = acciones.get(opcion - 1);
                try {
                    accion.ejecutar();
                    System.out.println("Acción ejecutada con éxito.\n");
                } catch (Exception e) {
                    System.out.println("Error al ejecutar la acción: " + e.getMessage());
                }
            } else {
                System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }
} 