import java.util.Scanner;

import programacion.empresaprogramacion.Empleado;
import programacion.empresaprogramacion.Empresa;
import programacion.empresaprogramacion.Gerente;
import programacion.empresaprogramacion.ParametroInvalidoException;
import programacion.empresaprogramacion.Programador;

public class MainEmpresaProgramadores {

  public static void main(String[] args) {

    Empresa empresa = new Empresa("Empresa del Juan de la Cierva");
    int opcion = 0;
    
    Scanner scanner = new Scanner(System.in);

    Empleado referencia;

    try {
      referencia = new Programador("P8701","Juan", 2500.0, "C++", false, true);
      empresa.addEmpleado(referencia);
    } catch (ParametroInvalidoException e) {
      System.out.println("Excepción capturada creando Programador: " + e.getMessage());
    }
    
    try {
    referencia = new Programador("P8702","Beatriz", 2000.0, "C++", true, false);
    empresa.addEmpleado(referencia);
  } catch (ParametroInvalidoException e) {
    System.out.println("Excepción capturada creando Programador: " + e.getMessage());
  }
  try {
    referencia = new Gerente("G8801","Luis", 3500.0, "Ventas");
    empresa.addEmpleado(referencia);
  } catch (ParametroInvalidoException e) {
    System.out.println("Excepción capturada creando Gerente: " + e.getMessage());
  }
  try {  
    referencia = new Gerente("G8802","Marcela", 4000.0, "Recursos Humanos");
    empresa.addEmpleado(referencia);
  } catch (ParametroInvalidoException e) {
    System.out.println("Excepción capturada creando Gerente: " + e.getMessage());
  }
  try {
    referencia = new Programador("P8703","Carlos", 2000.0, "Java", true, true);
    empresa.addEmpleado(referencia);
  } catch (ParametroInvalidoException e) {
    System.out.println("Excepción capturada creando Programador: " + e.getMessage());
  }
  try {
    referencia = new Programador("P8704","Ana", 3000.0, "Python", false, false);
    empresa.addEmpleado(referencia);
  } catch (ParametroInvalidoException e) {
    System.out.println("Excepción capturada creando Programador: " + e.getMessage());
  }
  try {
    referencia = new Programador("P8705","Pedro", 2200.0, "Java", true, true);
    empresa.addEmpleado(referencia);
  } catch (ParametroInvalidoException e) {
    System.out.println("Excepción capturada creando Programador: " + e.getMessage());
  }
  try {
    referencia = new Programador("P8706","Laura", 2600.0, "Java", false, true);
    empresa.addEmpleado(referencia);
  } catch (ParametroInvalidoException e) {
    System.out.println("Excepción capturada creando Programador: " + e.getMessage());
  }

    do {
      imprimirMenu();
      opcion = scanner.nextInt();
      scanner.nextLine(); // Limpiar buffer

      switch (opcion) {

        case 1:
          // Imprimir todos los empleados
          System.out.println(empresa.toStringEmpleados());
          break;

        case 2:
          // Imprimir programadores
          System.out.println(empresa.toStringProgramadores());
          break;

        case 3:
          // Imprimir empleados por sueldo de MAYOR A MENOR
          System.out.println(empresa.toStringOrdenSueldo());
          break;

        case 4:
          // Imprimir empleados por nombre
          System.out.println(empresa.toStringOrdenNombre());
          break;

        case 5:
          // Cargar desde CSV
          System.out.println("Ingrese el nombre del archivo CSV a cargar:");
          String archivoCargar = scanner.nextLine();
          empresa.cargarDesdeCSV(archivoCargar);
          break;

        case 6:
          // Guardar en CSV
          System.out.println("Ingrese el nombre del archivo CSV para guardar:");
          String archivoGuardar = scanner.nextLine();
          empresa.guardarEnCSV(archivoGuardar);
          break;

        case 7:
          System.out.println("Saliendo...");
          break;

        default:
          System.out.println("Opción inválida");
          break;
      }

    } while (opcion != 7);
    scanner.close();
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
