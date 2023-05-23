package programacion.empresaprogramacion;

import programacion.empresaprogramacion.excepciones.ParametroInvalidoException;

public class Programador extends Empleado {

  boolean esJunior;
  String lenguajeProgramacion;
  static final String CSV_HEADER = "DNI,NOMBRE,SUELDO,LENGUAJE_PROGRAMACIÓN,ES_JUNIOR";

  public Programador(String DNI,
                     String nombre,
                     Double sueldo,
                     String lenguajeProgramacion,
                     boolean esJunior) throws ParametroInvalidoException {
    super(DNI, nombre, sueldo, TipoEmpleado.PROGRAMADOR);
    this.lenguajeProgramacion = lenguajeProgramacion;
    this.esJunior = esJunior;
  }

  @Override
  public String toCsvLine() {
    return DNI + "," + NOMBRE + "," + sueldo + "," + lenguajeProgramacion + "," + esJunior;
  }

  @Override
  public String toString() {
    return super.toString() + " - " + lenguajeProgramacion + " - " + (esJunior ? "Junior" : "Senior");
  }
}
