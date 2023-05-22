import java.util.Scanner;

import programacion.empresaprogramacion.*;
import programacion.empresaprogramacion.excepciones.ParametroInvalidoException;

public class MainEmpresaProgramadores {
  public static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {

    Empresa empresa = new Empresa("Tecnologías Gyllenhaal");
    int opcion;

    Empleado referencia;

    try {
      referencia = new Programador("50549668S", "Daniel", 1302.93, true);
      empresa.addEmpleado(referencia);
    }catch (ParametroInvalidoException e) {
      System.out.println(e.getMessage());
    }

    try {
      referencia = new Programador("50782958C", "Max", 1342.55, true);
      empresa.addEmpleado(referencia);
    } catch (ParametroInvalidoException e) {
      System.out.println(e.getMessage());
    }

    try {
      referencia = new Gerente("50214985H", "Karla", 1824.73, "Contabilidad");
      empresa.addEmpleado(referencia);
    } catch (ParametroInvalidoException e) {
      System.out.println(e.getMessage());
    }
    ;

    try {
      referencia = new Gerente("02980444R", "Víctor", 1951.42, "Sistemas");
      empresa.addEmpleado(referencia);
    } catch (ParametroInvalidoException e) {
      System.out.println(e.getMessage());
    }

    try {
      referencia = new Programador("47274832J", "Valentín", 1300.00, true);
      empresa.addEmpleado(referencia);
    } catch (ParametroInvalidoException e) {
      System.out.println(e.getMessage());
    }


    try {
      referencia = new Programador("53688742H", "Fernando", 2159.02, false);
      empresa.addEmpleado(referencia);
    } catch (ParametroInvalidoException e) {
      System.out.println(e.getMessage());
    }

    try {
      referencia = new Programador("32831027M", "Michael", 1095.98, true);
      empresa.addEmpleado(referencia);
    } catch (ParametroInvalidoException e) {
      System.out.println(e.getMessage());
    }

    try {
      referencia = new Gerente("07762415B", "Sergio", 2257.25, "Automatización");
      empresa.addEmpleado(referencia);
    } catch (ParametroInvalidoException e) {
      System.out.println(e.getMessage());
    }

    do {
      imprimirMenu();
      opcion = Integer.parseInt(sc.nextLine());

      switch (opcion) {
        case 1 -> {
          // Imprimir los datos de la empresa
          System.out.println(empresa);
        }
        case 2 -> {
          // Imprimir los datos de la empresa y sus empleados
          System.out.println(empresa.toStringEmpresaYEmpleados());
        }
        case 3 ->
          // Imprimir solo programadores
                System.out.println(empresa.toStringProgramadores());
        case 4 ->
          // Imprimir empleados(todos) por sueldo de MAYOR A MENOR
                System.out.println(empresa.toStringEmpleadosOrdenadosPorSueldo());
        case 5 ->
          // Imprimir empleados(todos) por nombre
                System.out.println(empresa.toStringEmpleadosOrdenadosPorNombre());
        case 6 -> {
          // Cargar desde CSV
          System.out.print("\nIngrese el nombre del archivo CSV a cargar: ");
          String archivoCargar = sc.nextLine();
          empresa.cargarDesdeCSV(archivoCargar);
        }
        case 7 -> {
          // Guardar en CSV
          System.out.print("\nIngrese el nombre del archivo CSV para guardar: ");
          String archivoGuardar = sc.nextLine();
          empresa.guardarEnCSV(archivoGuardar);
        }
        case 8 -> System.out.println("\nSaliendo...");
        default -> System.out.println("\nOpción inválida\n");
      }
    } while (opcion != 7);
  }

  private static void imprimirMenu() {
    System.out.println("### Menú Empresa ###");
    System.out.println("1. Imprimir datos de la empresa");
    System.out.println("2. Imprimir todos los empleados");
    System.out.println("3. Imprimir todos los programadores");
    System.out.println("4. Imprimir empleados por sueldo");
    System.out.println("5. Imprimir empleados por nombre");
    System.out.println("6. Cargar desde fichero CSV");
    System.out.println("7. Guardar en CSV");
    System.out.println("8. Salir");
    System.out.print("Introduce una opción: ");
  }
}
