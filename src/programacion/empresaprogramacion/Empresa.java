package programacion.empresaprogramacion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Empresa {

  public static String nombre;
  public static final String CSV_OUTPUT_PATH_PROGRAMADORES = "outputProgramadores.csv";
  public static final String CSV_OUTPUT_PATH_GERENTES = "outputGerentes.csv";
  public static final String CSV_INPUT_PATH = "inputProgramadores.csv";
  public Map<String, Empleado> mapaEmpleados;

  public Empresa(String nombre) {
    Empresa.nombre = nombre;
    this.mapaEmpleados = new HashMap<>();
  }

  public static String getNombre() {
    return nombre;
  }

  public void addEmpleado(String dni, Empleado empleado) throws ParametroInvalidoException {
    if (dni.isEmpty()) {
      throw new ParametroInvalidoException(
          "El campo dni no puede estar vacio. Excepcion lanzada desde el metodo addEmpleado");
    }

    if (mapaEmpleados.containsKey(empleado.getDniEmpleado())) {
      throw new ParametroInvalidoException(
          "El dni ya existe en el sistema. Excepcion lanzada desde el metodo addEmpleado");
    }

    mapaEmpleados.put(dni, empleado);

  }

  public void escribirCsvDeProgramadores() {
    try (BufferedWriter escritor = new BufferedWriter(new FileWriter(CSV_OUTPUT_PATH_PROGRAMADORES))) {
      List<Empleado> listaEmpleados = new ArrayList<>(mapaEmpleados.values());
      escritor.write(Programador.getCsvHeader());
      for (Empleado empleado : listaEmpleados) {
        if (empleado instanceof Programador) {
          escritor.write(empleado.toCsvLine());
        }

      }

    } catch (Exception e) {
      System.out.println("Hubo un error escribiendo el archivo csv: " + e.getMessage());
    }
  }

  public void escribirCsvDeGerentes() {
    try (BufferedWriter escritor = new BufferedWriter(new FileWriter(CSV_OUTPUT_PATH_GERENTES))) {
      escritor.write(Gerente.GERENTE_CSV_HEADER);
      for (Empleado empleado : mapaEmpleados.values()) {
        if (empleado instanceof Gerente) {
          escritor.write(empleado.toCsvLine());
        }
      }
    } catch (Exception e) {
      System.out.println("Hubo un error escribiendo el archivo csv: " + e.getMessage());
    }
  }

  public void cargarDesdeCSV() {
    try (BufferedReader lector = new BufferedReader(new FileReader(CSV_INPUT_PATH))) {
      String line;
      line = lector.readLine(); // header skipped
      while ((line = lector.readLine()) != null) {
        String[] container = line.split(",");
        if ("PROGRAMADOR".equalsIgnoreCase(container[3])) {
          Double doubleParseado;
          Boolean booleanParseado;
          try {
            doubleParseado = Double.parseDouble(container[2]);
            booleanParseado = Boolean.parseBoolean(container[4]);

          } catch (NullPointerException | NumberFormatException e) {
            System.out.println("Error al parsear, formato incorrecto. " + e.getMessage());
            continue;
          }
          Empleado programador = new Programador(container[0], container[1], doubleParseado,
              TipoEmpleado.PROGRAMADOR, booleanParseado);
          try {
            if (mapaEmpleados.containsKey(programador.getDniEmpleado())) {
              throw new ParametroInvalidoException("No puede repetirse el DNI");
            } else {
              mapaEmpleados.put(container[0], programador);
            }
          } catch (ParametroInvalidoException e) {
            System.out.println("Ha habido un error leyendo la linea " + line +
                ". Excepcion lanzada: " + e.getMessage());

          }

        } else if ("GERENTE".equalsIgnoreCase(container[3])) {
          Empleado gerente = new Gerente(container[0], container[1],
              Double.parseDouble(container[2]), TipoEmpleado.GERENTE, container[4]);
          try {
            if (mapaEmpleados.containsKey(gerente.getDniEmpleado())) {
              throw new ParametroInvalidoException("No puede repetirse el DNI");
            } else {
              mapaEmpleados.put(container[0], gerente);
            }
          } catch (ParametroInvalidoException e) {
            System.out.println("Error al añadir gerente " + gerente.getNombre() + "/ " + e.getMessage());
          }

        }
      }

    } catch (Exception e) {
      System.out.println("Error al cargar el archivo CSV :" + e.getMessage());
    }

  }

  @Override
  public String toString() {
    List<Empleado> listaEmpleados = new ArrayList<>(mapaEmpleados.values());
    String cadena = "\n## " + nombre + " ##\n\n";
    for (Empleado empleado : listaEmpleados) {
      cadena += empleado;

    }
    return cadena;

  }

  public String toStringProgramadores() {
    List<Empleado> listaEmpleados = new ArrayList<>(mapaEmpleados.values());
    List<Programador> listaProgramadores = new ArrayList<>();

    for (Empleado empleado : listaEmpleados) {
      if (empleado.getTipo() == TipoEmpleado.PROGRAMADOR) {
        listaProgramadores.add((Programador) empleado);
      }
    }

    String cadena = "\n## Lista de programadores ##\n\n";
    for (Programador programador : listaProgramadores) {
      cadena = cadena + programador;
    }

    return cadena;

  }

  public String toStringGerentes() {
    List<Empleado> listaEmpleados = new ArrayList<>(mapaEmpleados.values());
    List<Gerente> listaGerentes = new ArrayList<>();

    for (Empleado empleado : listaEmpleados) {
      if (empleado.getTipo() == TipoEmpleado.GERENTE) {
        listaGerentes.add((Gerente) empleado);
      }
    }

    String cadena = "\n## Lista de gerentes ##\n\n";
    for (Gerente gerente : listaGerentes) {
      cadena = cadena + gerente;
    }

    return cadena;

  }

  public String toStringOrdenSueldo() {
    List<Empleado> listaEmpleados = new ArrayList<>(mapaEmpleados.values());
    Collections.sort(listaEmpleados, Empleado.COMPARATOR_SUELDO);
    Collections.reverse(listaEmpleados);
    String cadena = "\n## " + nombre + " ##\n\n  -Empleados ordenados por sueldo:\n\n";
    for (Empleado empleado : listaEmpleados) {
      cadena += empleado;

    }
    return cadena;

  }

  public String toStringOrdenNombre() {
    List<Empleado> listaEmpleadosNombre = new ArrayList<>(mapaEmpleados.values());
    Collections.sort(listaEmpleadosNombre, Empleado.COMPARATOR_NOMBRE);
    String cadena = "\n## " + nombre + "\n\n  -Empleados ordenados por nombre: \n\n";
    for (Empleado empleado : listaEmpleadosNombre) {
      cadena += empleado;
    }
    return cadena;
  }

}
