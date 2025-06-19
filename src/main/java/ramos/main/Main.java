package ramos.main;

import ramos.framework.MenuFramework;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Debe indicar el path del archivo de configuración como argumento.");
            System.exit(1);
        }
        String pathConfig = args[0];
        MenuFramework framework = new MenuFramework();
        try {
            framework.cargarAcciones(pathConfig);
            framework.ejecutar();
        } catch (Exception e) {
            System.out.println("Error al iniciar el framework: " + e.getMessage());
            e.printStackTrace();
        }
    }
} 