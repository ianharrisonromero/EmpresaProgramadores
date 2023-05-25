import java.util.Scanner;

import programacion.empresaprogramacion.Empleado;
import programacion.empresaprogramacion.Empresa;
import programacion.empresaprogramacion.Gerente;
import programacion.empresaprogramacion.ParametroInvalidoException;
import programacion.empresaprogramacion.Programador;

public class MainEmpresaProgramadores {
  static Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
    System.out.println("Nombre de la empresa: ");
    String nombreEmpresa = sc.nextLine();
    Empresa empresa = new Empresa(nombreEmpresa);
    int opcion = 0;
    try {
      Empleado referencia = new Programador("51001Z","Alek", (double) 2000, false);
      empresa.addEmpleado(referencia);
    } catch (ParametroInvalidoException e) {
      System.out.println("Error al crear nuevo empleado. " + e.getMessage());
    }
    
    try {
      Empleado referencia = new Programador("01X","Ishmir", 1400.0, true);
      empresa.addEmpleado(referencia);
    } catch (ParametroInvalidoException e) {
      System.out.println("Error al crear nuevo empleado. " + e.getMessage());
    }
    
    try {
      Empleado referencia = new Programador("51001Z","Ale", 1500.0, true);
      empresa.addEmpleado(referencia);
    } catch (ParametroInvalidoException e) {
      System.out.println("Error al crear nuevo empleado. " + e.getMessage());
    }

    try {
      Empleado referencia = new Gerente("512346V","Alek", (double) 2000, "Ventas");
      empresa.addEmpleado(referencia);
    } catch (ParametroInvalidoException e) {
      System.out.println("Error al crear nuevo empleado. " + e.getMessage());
    }

    try {
      Empleado referencia = new Gerente("712346P","Izan", (double) 2000, "Ventas");
      empresa.addEmpleado(referencia);
    } catch (ParametroInvalidoException e) {
      System.out.println("Error al crear nuevo empleado. " + e.getMessage());
    }

    try {
      Empleado referencia = new Gerente("512396F","Asriel", 1800.0, "Marketing");
      empresa.addEmpleado(referencia);
    } catch (ParametroInvalidoException e) {
      System.out.println("Error al crear nuevo empleado. " + e.getMessage());
    }

    do {
      imprimirMenu();
      opcion = sc.nextInt();
      sc.nextLine(); // Limpiar buffer

      switch (opcion) {

        case 1:
          // Imprimir los datos de la empresa y todos sus empleados
          System.out.println(empresa);
          break;

        case 2:
          // Imprimir solo programadores
          System.out.println(empresa.toStringProgramadores());
          
          break;

        case 3:
          // Imprimir empleados(todos) por sueldo de MAYOR A MENORç
          System.out.println(empresa.toStringOrdenSueldo());
          
          break;

        case 4:
          // Imprimir empleados(todos) por nombre
          System.out.println(empresa.toStringOrdenNombre());
          
          break;

        case 5:
          // Cargar desde CSV
          System.out.println("Ingrese el nombre del archivo CSV a cargar:");
          String archivoLectura = sc.nextLine();
          empresa.cargarDesdeCSV(archivoLectura);
          break;

        case 6:
          // Guardar en CSV
          empresa.guardarEnCSV();
          break;

        case 7:
          System.out.println("Saliendo...");
          break;

        default:
          System.out.println("Opción inválida");
          break;
      }

    } while (opcion != 7);
  }

  private static void imprimirMenu() {
    System.out.println("### Menú Empresa ###");
    System.out.println("1. Imprimir todos los empleados");
    System.out.println("2. Imprimir todos los programadores");
    System.out.println("3. Imprimir empleados por sueldo");
    System.out.println("4. Imprimir empleados por nombre");
    System.out.println("5. Cargar desde fichero CSV");
    System.out.println("6. Guardar en CSV");
    System.out.println("7. Salir");
    System.out.println("Introduce una opción:");
  }
}
