package programacion.empresaprogramacion;

public class Gerente extends Empleado {
  String departamento;
  static final String GERENTE_CSV_HEADER = EMPLEADO_CSV_HEADER + ",DEPARTAMENTO\n";

  public Gerente(String dniEmpleado, String nombre, double sueldo, TipoEmpleado tipo,
      String departamento) throws ParametroInvalidoException {
    super(dniEmpleado, nombre, sueldo, tipo);
    this.departamento = departamento;
  }

  @Override
  public String toString() {
    return super.toString() + String.format("%12s |\n",departamento);
  }

  public String toCsvHeader() {
    return GERENTE_CSV_HEADER;
  }

  public String toCsvLine() {
    String cadena = getDniEmpleado() + "/" + getNombre() + "/" + getSueldo() + "/" + getTipo() + "/"
        + departamento + "\n";
    return cadena;
  }

}
