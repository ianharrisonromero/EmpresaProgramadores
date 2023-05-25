package programacion.empresaprogramacion;

public class Programador extends Empleado{

  private boolean esJunior;
  //no entiendo del enunciado a qué se refiere con lo del lenguaje, 
  //pensaba añadir una lista y un setter por si va aprendiendo.

  public Programador(String dniEmpleado, String nombre, Double sueldo, boolean esJunior) throws ParametroInvalidoException{
    super(dniEmpleado, nombre, sueldo);
    this.esJunior = esJunior;
  }



  @Override
  public String toString() {
    super.toString();
    return esJunior ? "es Junior." : "es Senior.";
  }

}
