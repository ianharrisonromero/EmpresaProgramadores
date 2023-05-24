import java.util.Scanner;

import programacion.empresaprogramacion.Empleado;
import programacion.empresaprogramacion.Empresa;
import programacion.empresaprogramacion.Gerente;
import programacion.empresaprogramacion.ParametroInvalidoException;
import programacion.empresaprogramacion.Programador;
import programacion.empresaprogramacion.TipoEmpleado;;

public class MainEmpresaProgramadores {

  public static void main(String[] args) {

    Empresa empresa = new Empresa("Empresa del Juan de la Cierva");
    int opcion = 0;
    Scanner scanner = new Scanner(System.in);

    try {
      Empleado programador = new Programador("44332211D", "Carlos Sánchez",
          3000.0, TipoEmpleado.PROGRAMADOR, true);
      String dni = programador.getDniEmpleado();
      empresa.addEmpleado(dni, programador);
    } catch (ParametroInvalidoException e) {
      System.out.println("Excepcion capturada, hubo un error añadiendo al empleado: "
          + e.getMessage());
    }

    try {
      Empleado programador = new Programador("99887766E", "Ana López",
          2500.0, TipoEmpleado.PROGRAMADOR, false);
      String dni = programador.getDniEmpleado();
      empresa.addEmpleado(dni, programador);
    } catch (ParametroInvalidoException e) {
      System.out.println("Excepcion capturada, hubo un error añadiendo al empleado: "
          + e.getMessage());
    }

    try {
      Empleado programador = new Programador("55443322F", "Pedro Martínez",
          3500.0, TipoEmpleado.PROGRAMADOR, true);
      String dni = programador.getDniEmpleado();
      empresa.addEmpleado(dni, programador);
    } catch (ParametroInvalidoException e) {
      System.out.println("Excepcion capturada, hubo un error añadiendo al empleado: "
          + e.getMessage());
    }

    try {
      Empleado programador = new Programador("00998877H", "Luis González",
          3200.0, TipoEmpleado.PROGRAMADOR, false);
      String dni = programador.getDniEmpleado();
      empresa.addEmpleado(dni, programador);
    } catch (ParametroInvalidoException e) {
      System.out.println("Excepcion capturada, hubo un error añadiendo al empleado: "
          + e.getMessage());
    }

    try {
      Empleado programador = new Programador("22334455I", "María Fernández",
          2900.0, TipoEmpleado.PROGRAMADOR, true);
      String dni = programador.getDniEmpleado();
      empresa.addEmpleado(dni, programador);
    } catch (ParametroInvalidoException e) {
      System.out.println("Excepcion capturada, hubo un error añadiendo al empleado: "
          + e.getMessage());
    }

    try {
      Empleado programador = new Programador("77665544J", "David Rodríguez",
          2700.0, TipoEmpleado.PROGRAMADOR, false);
      String dni = programador.getDniEmpleado();
      empresa.addEmpleado(dni, programador);
    } catch (ParametroInvalidoException e) {
      System.out.println("Excepcion capturada, hubo un error añadiendo al empleado: "
          + e.getMessage());
    }

    try {
      Empleado gerente = new Gerente("55667788B", "Juan Rodríguez",
          4500.0, TipoEmpleado.GERENTE, "Finanzas");
      String dni = gerente.getDniEmpleado();
      empresa.addEmpleado(dni, gerente);
    } catch (ParametroInvalidoException e) {
      System.out.println("Excepcion capturada, hubo un error añadiendo al empleado: "
          + e.getMessage());
    }

    try {
      Empleado gerente = new Gerente("99001122C", "Laura Martínez",
          3800.0, TipoEmpleado.GERENTE, "Marketing");
      String dni = gerente.getDniEmpleado();
      empresa.addEmpleado(dni, gerente);
    } catch (ParametroInvalidoException e) {
      System.out.println("Excepcion capturada, hubo un error añadiendo al empleado: "
          + e.getMessage());
    }

    do {
      imprimirMenu();
      opcion = scanner.nextInt();
      scanner.nextLine(); // Limpiar buffer

      switch (opcion) {

        case 1:
          // Imprimir los datos de la empresa y todos sus empleados
          System.out.println(empresa);
          ;
          break;

        case 2:
          System.out.println(empresa.toStringProgramadores());
          break;

        case 3:
          System.out.println(empresa.toStringGerentes());
          break;

        case 4:
          System.out.println(empresa.toStringOrdenSueldo());
          break;

        case 5:
          System.out.println(empresa.toStringOrdenNombre());
          break;

        case 6:
          // Cargar desde CSV
          System.out.println("Ingrese el nombre del archivo CSV a cargar:");
          String archivoCargar = scanner.nextLine();
          empresa.cargarDesdeCSV(archivoCargar);
          break;

        case 7:
          // Escribir programadores en CSV
          System.out.println("Ingrese el nombre del archivo CSV para guardar programadores:");
          String archivoGuardarProgramadores = scanner.nextLine();
          empresa.escribirCsvDeProgramadores(archivoGuardarProgramadores);
          break;

        case 8:
          // Escribir gerentes en CSV
          System.out.println("Ingrese el nombre del archivo CSV para guardar a los gerentes:");
          String archivoGuardarGerentes = scanner.nextLine();
          empresa.escribirCsvDeGerentes(archivoGuardarGerentes);
          break;

        case 9:
          System.out.println("Saliendo...");
          break;

        default:
          System.out.println("Opción inválida");
          break;
      }

    } while (opcion != 9);
  }

  private static void imprimirMenu() {
    System.out.println("### Menú " + Empresa.getNombre() + " ###");
    System.out.println("1. Imprimir todos los empleados");
    System.out.println("2. Imprimir todos los programadores");
    System.out.println("3. Imprimir todos los gerentes");
    System.out.println("4. Imprimir empleados por sueldo");
    System.out.println("5. Imprimir empleados por nombre");
    System.out.println("6. Cargar programadores desde fichero CSV");
    System.out.println("7. Escribir programadores en CSV");
    System.out.println("8. Escribir gerentes en fichero CSV");
    System.out.println("9. Salir");
    System.out.print("Introduce una opción: ");
  }
}
