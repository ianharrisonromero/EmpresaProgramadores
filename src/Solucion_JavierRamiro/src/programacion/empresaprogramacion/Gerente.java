package programacion.empresaprogramacion;

public class Gerente extends Empleado {
  private String departamento;

  public Gerente(String nombre, double sueldo, String departamento2) {
      super(nombre, sueldo);
  }

  public String getDepartamento() {
      return departamento;
  }

  @Override
  public TipoEmpleado getTipo() {
      return TipoEmpleado.GERENTE;
  }

  @Override
  public String toString() {
      return "Gerente [nombre=" + getNombre() + ", sueldo=" + getSueldo() + ", departamento=" + departamento + "]";
  }
}
