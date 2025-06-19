# Framework de Acciones por Consola

Este framework permite crear aplicaciones de consola que muestran un menú de acciones configurables, ejecutan acciones seleccionadas por el usuario y permiten extender fácilmente la funcionalidad mediante una interfaz.

## Estructura del Framework

- **Paquete principal:** `ramos.framework`
- **Interfaz de extensión:**
  ```java
  public interface Accion {
      void ejecutar();
      String nombreItemMenu();
      String descripcionItemMenu();
  }
  ```
- **Clase principal:** `MenuFramework` (gestiona el menú, la carga de acciones y la ejecución)

## ¿Cómo compilar y generar el JAR del framework?

1. Compila el proyecto y genera el JAR del framework:
   ```sh
   mvn clean package
   ```
   Esto generará un archivo `target/TP-Frameworks-1.0-SNAPSHOT-framework.jar` que contiene **solo el framework**.

2. (Opcional) Renómbralo a `framework-v1.0.jar`:
   ```sh
   ren target/TP-Frameworks-1.0-SNAPSHOT-framework.jar framework-v1.0.jar
   ```

## ¿Cómo usar el framework en otro proyecto?

### Opción 1: Agregar el JAR manualmente al classpath

1. Copia `framework-v1.0.jar` a la carpeta de tu nuevo proyecto (por ejemplo, `lib/`).
2. Implementa tus propias acciones en tu proyecto, por ejemplo:
   ```java
   import ramos.framework.Accion;

   public class MiAccion implements Accion {
       public void ejecutar() { System.out.println("¡Hola!"); }
       public String nombreItemMenu() { return "Saludo"; }
       public String descripcionItemMenu() { return "Saluda al usuario"; }
   }
   ```
3. Usa el framework en tu clase principal:
   ```java
   import ramos.framework.MenuFramework;

   public class Main {
       public static void main(String[] args) throws Exception {
           MenuFramework framework = new MenuFramework();
           framework.cargarAcciones("ruta/a/acciones.txt");
           framework.ejecutar();
       }
   }
   ```
4. Compila y ejecuta incluyendo el JAR en el classpath:
   ```sh
   javac -cp lib/framework-v1.0.jar src/tu/paquete/*.java
   java -cp lib/framework-v1.0.jar;src tu.paquete.Main
   ```

### Opción 2: Usar Maven y agregar el JAR como dependencia local

1. Instala el JAR en tu repositorio local de Maven:
   ```sh
   mvn install:install-file -Dfile=framework-v1.0.jar -DgroupId=ramos -DartifactId=framework -Dversion=1.0 -Dpackaging=jar
   ```
2. Agrega la dependencia en el `pom.xml` de tu proyecto cliente:
   ```xml
   <dependency>
       <groupId>ramos</groupId>
       <artifactId>framework</artifactId>
       <version>1.0</version>
   </dependency>
   ```

## Archivo de configuración de acciones

El framework carga las acciones a mostrar en el menú desde un archivo de texto, donde cada línea es el nombre completo de una clase que implementa `Accion`.

Ejemplo de `acciones.txt`:
```
tu.paquete.MiAccion
```

## Ejemplo de menú generado

```
=== MENÚ ===
1. Saludo - Saluda al usuario
2. Salir
Seleccione una opción:
```

## Ejemplo de implementación de una acción

```java
import ramos.framework.Accion;

public class MiAccion implements Accion {
    public void ejecutar() {
        System.out.println("¡Hola, mundo!");
    }
    public String nombreItemMenu() {
        return "Saludo";
    }
    public String descripcionItemMenu() {
        return "Saluda al usuario";
    }
}
```

## Licencia

Uso académico y libre distribución para prácticas universitarias. 