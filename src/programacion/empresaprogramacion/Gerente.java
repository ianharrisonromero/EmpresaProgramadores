package programacion.empresaprogramacion;

import programacion.empresaprogramacion.excepciones.ParametroInvalidoException;

public class Gerente extends Empleado{
  String departamento;
  static final String CSV_HEADER = "DNI,NOMBRE,SUELDO,DEPARTAMENTO";

  public Gerente(String DNI, String nombre, Double sueldo, String departamento) throws ParametroInvalidoException {
    super(DNI, nombre, sueldo, TipoEmpleado.GERENTE);
    this.departamento = departamento;
  }

  @Override
  public String toCsvLine() {
    return DNI+ "," + NOMBRE + "," + sueldo + "," + departamento;
  }

  @Override
  public String toString() {
    return super.toString() + " - "+departamento;
  }
}
