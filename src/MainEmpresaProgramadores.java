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
          empresa.cargarDesdeCSV();
          break;

        case 7:
          // Escribir programadores en CSV
          empresa.escribirCsvDeProgramadores();
          break;

        case 8:
          // Escribir gerentes en CSV
          empresa.escribirCsvDeGerentes();
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
