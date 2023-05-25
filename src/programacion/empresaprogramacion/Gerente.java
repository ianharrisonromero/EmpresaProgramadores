package programacion.empresaprogramacion;

public class Gerente extends Empleado{
  private String departamento;

  public Gerente(String dniEmpleado, String nombre, Double sueldo, String departamento) throws ParametroInvalidoException {
    super(dniEmpleado, nombre, sueldo);
    this.departamento = departamento;
  }

  public String getDepartamento() {
    return departamento;
  }

  //porque puede que cambie de departamento.
  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }
}
