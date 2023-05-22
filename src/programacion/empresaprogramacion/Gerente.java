package programacion.empresaprogramacion;

public class Gerente extends Empleado {

  private String departamento;

  public Gerente(String idEmpleado, String nombre, double sueldo, String departamento) throws ParametroInvalidoException {
    super(idEmpleado, nombre, sueldo, TipoEmpleado.GERENTE);
    if (departamento.isEmpty()){
      throw new ParametroInvalidoException("Nombre departamento vacio.");
    }
    this.departamento = departamento;
  }
  /* NO SE USA
  public String getDepartamento() {
    return departamento;
  }
  */
  
  public String toString(){
    //Sobrescribimos el metodo toString de la clase Empleado
    return "|Gerente|" + super.toString() + ", Departamento: "+ departamento;
  }
  
}