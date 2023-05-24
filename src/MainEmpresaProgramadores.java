import programacion.empresaprogramacion.Empleado;
import programacion.empresaprogramacion.Empresa;
import programacion.empresaprogramacion.Gerente;
import programacion.empresaprogramacion.Programador;
import programacion.empresaprogramacion.excepciones.ParametroInvalidoException;
import programacion.empresaprogramacion.excepciones.RutaArchivoInvalida;

import java.util.Scanner;

public class MainEmpresaProgramadores {
  public static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {

    Empresa empresa = new Empresa("Tecnologías Gyllenhaal");
    int opcion;

    Empleado referencia;

    try {
      //DNI CORRECTO, NOMBRE CORRECTO, SUELDO CORRECTO
      referencia = new Programador("50549668S", "Daniel", 1302.93, "Java", true);
      empresa.addEmpleado(referencia);
    } catch (ParametroInvalidoException e) {
      System.out.println("Excepción por ParametroInvalido creando "+ TipoEmpleado.PROGRAMADOR +": " + e.getMessage());
    }

    try {
      //DNI CORRECTO, NOMBRE MAL, SUELDO CORRECTO
      referencia = new Programador("50782958Q", "M", 1342.55, "PL/SQL", true);
      empresa.addEmpleado(referencia);
    } catch (ParametroInvalidoException e) {
      System.out.println("Excepción por ParametroInvalido creando "+ TipoEmpleado.PROGRAMADOR +": " + e.getMessage());
    }

    try {
      //DNI CORRECTO, NOMBRE CORRECTO, SUELDO CORRECTO
      referencia = new Gerente("50214985M", "Karla", 1824.73, "Contabilidad");
      empresa.addEmpleado(referencia);
    } catch (ParametroInvalidoException e) {
      System.out.println("Excepción por ParametroInvalido creando "+ TipoEmpleado.GERENTE +": " + e.getMessage());
    }

    try {
      //DNI CORRECTO, NOMBRE CORRECTO, SUELDO CORRECTO
      referencia = new Gerente("02765008V", "Víctor", 1951.42, "Sistemas");
      empresa.addEmpleado(referencia);
    } catch (ParametroInvalidoException e) {
      System.out.println("Excepción por ParametroInvalido creando "+ TipoEmpleado.GERENTE +": " + e.getMessage());
    }

    try {
      //DNI INCORRECTO, LETRA, NOMBRE CORRECTO, SUELDO CORRECTO
      referencia = new Programador("47274832J", "Valentín", 1300.00, "Java", true);
      empresa.addEmpleado(referencia);
    } catch (ParametroInvalidoException e) {
      System.out.println("Excepción por ParametroInvalido creando "+ TipoEmpleado.PROGRAMADOR +": " + e.getMessage());
    }

    try {
      //DNI INCORRECTO, MAL FORMADO, NOMBRE CORRECTO, SUELDO CORRECTO
      referencia = new Programador("053888742H", "Fernando", 2159.02, "C++", false);
      empresa.addEmpleado(referencia);
    } catch (ParametroInvalidoException e) {
      System.out.println("Excepción por ParametroInvalido creando "+ TipoEmpleado.PROGRAMADOR +": " + e.getMessage());
    }

    try {
      //DNI CORRECTO, NOMBRE CORRECTO, SUELDO NEGATIVO
      referencia = new Programador("32831027E", "Michael", -1203.02, "Bash", true);
      empresa.addEmpleado(referencia);
    } catch (ParametroInvalidoException e) {
      System.out.println("Excepción por ParametroInvalido creando "+ TipoEmpleado.PROGRAMADOR +": " + e.getMessage());
    }

    try {
      //DNI CORRECTO, NOMBRE CORRECTO, SUELDO CORRECTO
      referencia = new Gerente("07762415F", "Sergio", 2257.25, "Automatización");
      empresa.addEmpleado(referencia);
    } catch (ParametroInvalidoException e) {
      System.out.println("Excepción por ParametroInvalido creando "+ TipoEmpleado.GERENTE +": " + e.getMessage());
    }

    do {
      imprimirMenu();
      opcion = Integer.parseInt(sc.nextLine());

      switch (opcion) {
        case 1 ->
          // Imprimir los datos de la empresa
                System.out.println(empresa);
        case 2 ->
          // Imprimir los datos de la empresa y sus empleados
                System.out.println(empresa.toStringEmpresaYEmpleados());
        case 3 ->
          // Imprimir solo programadores
                System.out.println(empresa.toStringProgramadores());
        case 4 ->
          // Imprimir empleados(todos) por sueldo de MAYOR A MENOR
                System.out.println(empresa.toStringEmpleadosOrdenadosPorSueldo());
        case 5 ->
          // Imprimir empleados(todos) por nombre
                System.out.println(empresa.toStringEmpleadosOrdenadosPorNombre());
        case 6 ->
          // Imprimir empleados(todos) por DNI
                System.out.println(empresa.toStringEmpleadosOrdenadosPorDNI());
        case 7 -> {
          // Cargar desde CSV
          System.out.print("\nIngrese el nombre del archivo CSV a cargar: ");
          String archivoCargar = sc.nextLine();
          empresa.cargarDesdeCSV(archivoCargar);
        }
        case 8 -> {
          // Guardar en CSV
          System.out.print("\nIngrese el nombre del archivo CSV para guardar: ");
          String archivoGuardar = sc.nextLine();
          try{
            empresa.guardarEnCSV(archivoGuardar);
          } catch (RutaArchivoInvalida e) {
            System.out.println(e.getMessage());
          }
        }
        case 9 -> System.out.println("\nSaliendo...");
        default -> System.out.println("\nOpción inválida\n");
      }
    } while (opcion != 9);
  }

  private static void imprimirMenu() {
    System.out.println("### Menú Empresa ###");
    System.out.println("1. Imprimir datos de la empresa");
    System.out.println("2. Imprimir todos los empleados");
    System.out.println("3. Imprimir todos los programadores");
    System.out.println("4. Imprimir empleados por sueldo");
    System.out.println("5. Imprimir empleados por nombre");
    System.out.println("6. Imprimir empleados por DNI");
    System.out.println("7. Cargar desde fichero CSV");
    System.out.println("8. Guardar en CSV");
    System.out.println("9. Salir");
    System.out.print("Introduce una opción: ");
  }
}
