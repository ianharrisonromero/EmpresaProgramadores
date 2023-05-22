package programacion.empresaprogramacion;

public abstract class Empleado{
  final String DNI;
  final String NOMBRE;
  Double sueldo;
  TipoEmpleado tipoEmpleado;

  public Empleado(String DNI, String nombre, Double sueldo, TipoEmpleado tipoEmpleado) {
    this.DNI = DNI;
    this.NOMBRE = nombre;
    this.sueldo = sueldo;
    this.tipoEmpleado = tipoEmpleado;
  }

  public String getDNI() {
    return DNI;
  }

  public String getNOMBRE() {
    return NOMBRE;
  }

  public Double getSueldo() {
    return sueldo;
  }

  public void setSueldo(Double sueldo) {
    this.sueldo = sueldo;
  }

  /**
   * Devuelve el tipo de empleado como String.
   * @return String
   */
  public String getTipoEmpleado() {
    return tipoEmpleado.toString();
  }

  @Override
  public String toString() {
    return String.format("%s - %s - %.2f%s", DNI, NOMBRE, sueldo, "€");
  }
}
