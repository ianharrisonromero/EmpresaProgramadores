package programacion.empresaprogramacion;

import java.util.Comparator;

public abstract class Empleado{
  final String DNI;
  final String NOMBRE;
  Double sueldo;
  TipoEmpleado tipoEmpleado;
  static final Comparator<Empleado> COMPARATOR_SUELDO = new Comparator<>() {
    @Override
    public int compare(Empleado o1, Empleado o2) {
      return o1.sueldo.compareTo(o2.sueldo);
    }
  };
  static final Comparator<Empleado> COMPARATOR_NOMBRE = new Comparator<>() {
    @Override
    public int compare(Empleado o1, Empleado o2) {
      return o1.NOMBRE.compareTo(o2.NOMBRE);
    }
  };

  public Empleado(String DNI, String nombre, Double sueldo, TipoEmpleado tipoEmpleado) {
    this.DNI = DNI;
    this.NOMBRE = nombre;
    this.sueldo = sueldo;
    this.tipoEmpleado = tipoEmpleado;
  }

  public abstract String toCsvLine();

  @Override
  public String toString() {
    return String.format("%s - %s - %.2f%s", DNI, NOMBRE, sueldo, "€");
  }
}
