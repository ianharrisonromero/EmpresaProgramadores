import java.util.Scanner;
import programacion.empresaprogramacion.Empresa;
import programacion.empresaprogramacion.Gerente;
import programacion.empresaprogramacion.Programador;

public class MainEmpresaProgramadores {

  public static void main(String[] args) {

    Empresa empresa = new Empresa("Empresa del Juan de la Cierva");
    int opcion = 0;
    // PruebaPrimerosCambiosBranchEloy;

    Scanner scanner = new Scanner(System.in);

    referencia = new Programador(parametros);
    empresa.addEmpleado(referencia);

    referencia = new Programador(parametros);
    empresa.addEmpleado(referencia);

    referencia = new Gerente(parametros);
    empresa.addEmpleado(referencia);

    referencia = new Gerente(parametros);
    empresa.addEmpleado(referencia);

    referencia = new Programador(parametros);
    empresa.addEmpleado(referencia);

    referencia = new Programador(parametros);
    empresa.addEmpleado(referencia);

    referencia = new Programador(parametros);
    empresa.addEmpleado(referencia);

    referencia = new Programador(parametros);
    empresa.addEmpleado(referencia);

    do {
      imprimirMenu();
      opcion = scanner.nextInt();
      scanner.nextLine(); // Limpiar buffer

      switch (opcion) {

        case 1:
          // Imprimir todos los empleados
          empresa.toStringEmpleados();
          break;

        case 2:
          // Imprimir programadores
          empresa.toStringProgramadores();
          break;

        case 3:
          // Imprimir empleados por sueldo de MAYOR A MENOR
          empresa.toStringOrdenSueldo();
          break;

        case 4:
          // Imprimir empleados por nombre
          empresa.toStringOrdenNombre();
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
