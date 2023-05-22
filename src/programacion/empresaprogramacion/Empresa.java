package programacion.empresaprogramacion;

import programacion.empresaprogramacion.excepciones.ParametroInvalidoException;

import java.util.HashMap;
import java.util.Map;

public class Empresa {

  public String nombre;
  public Map<String, Empleado> mapaEmpleados;


  public Empresa(String nombre) {
    this.nombre = nombre;
    mapaEmpleados = new HashMap<>();
  }

  public void addEmpleado(Empleado empleado) throws ParametroInvalidoException {
    if (mapaEmpleados.containsKey(empleado.DNI)) {
      if (empleado.tipoEmpleado == TipoEmpleado.PROGRAMADOR) {
        throw new ParametroInvalidoException("Ya existe un Programador con ese ID de empleado.\n");
      } else {
        throw new ParametroInvalidoException("Ya existe un Gerente con ese ID de empleado.\n");
      }
    } else {
      mapaEmpleados.put(empleado.DNI, empleado);
    }
  }

  public void guardarEnCSV(String archivoGuardar) {
    //TODO
  }

  public void cargarDesdeCSV(String archivoCargar) {
    //TODO

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

    // TODO ordenar todos los empleados por orden de sueldo de MAYOR A MENOR,
    // mostrándolo
    return null;
  }

  public String toStringEmpleadosOrdenadosPorNombre() {
    // TODO ordenar todos los empleados por orden de nombre alfabético, mostrándolo
    return null;
  }

}
