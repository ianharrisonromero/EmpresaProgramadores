package programacion.empresaprogramacion;

public class Programador extends Empleado{

  boolean esJunior;

  public Programador(String DNI, String nombre, Double sueldo, boolean esJunior) {
    super(DNI, nombre, sueldo, TipoEmpleado.PROGRAMADOR);
    this.esJunior = esJunior;
  }

  @Override
  public String toString() {
    return super.toString()+" - "+(esJunior?"Junior":"Senior");
  }
}
