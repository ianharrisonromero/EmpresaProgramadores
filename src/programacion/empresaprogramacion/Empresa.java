package programacion.empresaprogramacion;

import programacion.empresaprogramacion.excepciones.ParametroInvalidoException;
import programacion.empresaprogramacion.excepciones.RutaArchivoInvalida;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Empresa {

  public String nombre;
  public Map<String, Empleado> mapaEmpleados;
  static final String CSV_FILENAME_PROGRAMADORES = "programadores.csv";
  static final String CSV_FILENAME_GERENTES = "gerentes.csv";

  public Empresa(String nombre) {
    this.nombre = nombre;
    mapaEmpleados = new HashMap<>();
  }

  public void addEmpleado(Empleado empleado) throws ParametroInvalidoException {
    if (mapaEmpleados.containsKey(empleado.DNI)) {
      throw new ParametroInvalidoException("Ya existe un " + empleado.tipoEmpleado + " con ese ID de empleado.\n");
    } else {
      mapaEmpleados.put(empleado.DNI, empleado);
    }
  }

  public void guardarEnCSV(String archivoGuardar) throws RutaArchivoInvalida {
    List<Programador> programadores = new ArrayList<>();
    List<Gerente> gerentes = new ArrayList<>();

    for (Empleado empleado : mapaEmpleados.values()) {
      if(empleado instanceof Programador){
        programadores.add((Programador) empleado);
      } else {
        gerentes.add((Gerente) empleado);
      }
    }

    Iterator<Programador> iteradorProgramadores = programadores.iterator();
    Iterator<Gerente> iteradorGerentes = gerentes.iterator();

    try{
      File archivo = new File(archivoGuardar);
      if (archivoGuardar.equalsIgnoreCase(CSV_FILENAME_PROGRAMADORES)){
        if (comprobarArchivo(archivo)){
          if (archivo.createNewFile()){
            System.out.println("El archivo se ha creado correctamente.");
          } else {
            throw new RutaArchivoInvalida("El archivo no se ha podido crear.");
          }
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))){
          bw.write(Programador.CSV_HEADER);
          bw.newLine();
          while(iteradorProgramadores.hasNext()){
            bw.write(iteradorProgramadores.next().toCsvLine());
            bw.newLine();
          }
          bw.flush();
        } catch (IOException e) {
          System.out.println("Error al guardar el archivo. " + e.getMessage());
        }
      } else if (archivoGuardar.equalsIgnoreCase(CSV_FILENAME_GERENTES)){
        if (comprobarArchivo(archivo)){
          if (archivo.createNewFile()){
            System.out.println("El archivo se ha creado correctamente.");
          } else {
            throw new RutaArchivoInvalida("El archivo no se ha podido crear.");
          }
        }
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))){
          bw.write(Gerente.CSV_HEADER);
          bw.newLine();
          while(iteradorGerentes.hasNext()){
            bw.write(iteradorGerentes.next().toCsvLine());
            bw.newLine();
          }
          bw.flush();
        } catch (IOException e) {
          System.out.println("Error al guardar el archivo. " + e.getMessage());
        }
    }else{
        throw new RutaArchivoInvalida("El nombre del archivo no es válido. Si estás guardando programadores el nombre del archivo es: "+CSV_FILENAME_PROGRAMADORES+" y si estás guardando gerentes el nombre del archivo es: "+CSV_FILENAME_GERENTES+".\n");
      }
    } catch (IOException e) {
      System.out.println("Error al guardar el archivo. " + e.getMessage());
    }
  }

  public void cargarDesdeCSV(String archivoCargar) {
    try(BufferedReader br = new BufferedReader(new FileReader(archivoCargar))) {
      String linea;
      String[] datos;
      br.readLine();
      while((linea = br.readLine()) != null){
        datos = linea.split(",");
        if (archivoCargar.equalsIgnoreCase(CSV_FILENAME_PROGRAMADORES)){
          Programador programador;
          try{
            programador = new Programador(datos[0], datos[1], Double.parseDouble(datos[2]), datos[3], Boolean.parseBoolean(datos[4]));
            mapaEmpleados.put(programador.DNI, programador);
          }catch(ParametroInvalidoException | NullPointerException e){
            System.out.println(e.getMessage());
          }
        } else if (archivoCargar.equalsIgnoreCase(CSV_FILENAME_GERENTES)){
            Gerente gerente;
          try{
            gerente = new Gerente(datos[0], datos[1], Double.parseDouble(datos[2]), datos[3]);
            mapaEmpleados.put(gerente.DNI, gerente);
          }catch(ParametroInvalidoException | NullPointerException e){
            System.out.println(e.getMessage());
          }
        } else {
          System.out.println("El nombre del archivo no es válido. Si estás cargando programadores el nombre del archivo es: "+CSV_FILENAME_PROGRAMADORES+" y si estás cargando gerentes el nombre del archivo es: "+CSV_FILENAME_GERENTES+".\n");
        }
      }
    } catch (IOException e) {
      System.out.println("Error al leer el archivo. " + e.getMessage());
    }
  }

  public boolean comprobarArchivo(File archivo) throws RutaArchivoInvalida {
    if(archivo.exists()){
      if (archivo.delete()){
        System.out.println("El archivo ya existe y se ha borrado.");
        return true;
      } else {
        throw new RutaArchivoInvalida("El archivo ya existe y no se ha podido borrar.");
      }
    }
    return false;
  }

  @Override
  public String toString() {
    return "\n### " + nombre + " ###\n";
  }

  public String toStringEmpresaYEmpleados() {
    return this + "Lista de empleados:\n" + toStringEmpleados();
  }

  public String toStringEmpleados() {
    StringBuilder sb = new StringBuilder();
    for (Empleado empleado : mapaEmpleados.values()) {
      sb.append(empleado.toString() + "\n");
    }
    return sb.toString();
  }

  public String toStringProgramadores() {
    StringBuilder sb = new StringBuilder();
    if (this.mapaEmpleados.isEmpty()) {
      return "No hay programadores en la empresa.\n";
    }
    sb.append(this);
    sb.append("\nLista de programadores:\n");
    for (Empleado empleado : mapaEmpleados.values()) {
      if (empleado.tipoEmpleado.equals(TipoEmpleado.PROGRAMADOR)) {
        sb.append(empleado + "\n");
      }
    }
    return sb.toString();
  }

  public String toStringEmpleadosOrdenadosPorSueldo() {
    StringBuilder sb = new StringBuilder();
    ArrayList<Empleado> listaEmpleadosOrdenadosPorSueldo = new ArrayList<>(mapaEmpleados.values());
    listaEmpleadosOrdenadosPorSueldo.sort(Empleado.COMPARATOR_SUELDO.reversed());
    sb.append("\nLista de empleados ordenados por Sueldo:\n\n");
    for (Empleado empleado : listaEmpleadosOrdenadosPorSueldo) {
      sb.append(empleado);
      sb.append("\n");
    }
    return sb.toString();
  }

  public String toStringEmpleadosOrdenadosPorNombre() {
    StringBuilder sb = new StringBuilder();
    ArrayList<Empleado> listaEmpleadosOrdenadosPorSueldo = new ArrayList<>(mapaEmpleados.values());
    listaEmpleadosOrdenadosPorSueldo.sort(Empleado.COMPARATOR_NOMBRE);
    sb.append("\nLista de empleados ordenados por Nombre:\n\n");
    for (Empleado empleado : listaEmpleadosOrdenadosPorSueldo) {
      sb.append(empleado);
      sb.append("\n");
    }
    return sb.toString();
  }

  public String toStringEmpleadosOrdenadosPorDNI() {
    StringBuilder sb = new StringBuilder();
    TreeMap<String, Empleado> mapaEmpleadosOrdenadosPorDNI = new TreeMap<>(mapaEmpleados);
    sb.append("\nLista de empleados ordenados por DNI:\n\n");
    for (Empleado empleado : mapaEmpleadosOrdenadosPorDNI.values()) {
      sb.append(empleado);
      sb.append("\n");
    }
    return sb.toString();
  }
}
