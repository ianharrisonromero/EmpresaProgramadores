package programacion.empresaprogramacion;

public class Gerente extends Empleado{
  String departamento;

  public Gerente(String DNI, String nombre, Double sueldo, String departamento) {
    super(DNI, nombre, sueldo, TipoEmpleado.GERENTE);
    this.departamento = departamento;
  }

  @Override
  public String toString() {
    return super.toString() + " - "+departamento;
  }
}
