package programacion.empresaprogramacion;

public class Programador extends Empleado {

  boolean esJunior;
  public static final String PROGRAMADOR_CSV_HEADER = EMPLEADO_CSV_HEADER + ",RANGO\n";


  public Programador(String dniEmpleado, String nombre, double sueldo, TipoEmpleado tipo, boolean esJunior) throws ParametroInvalidoException {
    super(dniEmpleado, nombre, sueldo, TipoEmpleado.PROGRAMADOR);
    this.esJunior = esJunior;
  }

  @Override
  public String toString() {
    return super.toString() + String.format("%12s |\n", (esJunior ? "ES JUNIOR" : "ES SENIOR"));
  }

  public static String getCsvHeader() {
    return PROGRAMADOR_CSV_HEADER;
  }

  @Override
  public String toCsvLine() {
    String cadena = getDniEmpleado() + "," + getNombre() + "," + getSueldo() + "," + getTipo() + ","
        + (esJunior ? "es junior" : "es senior") + "\n";
    return cadena;
  }

}
