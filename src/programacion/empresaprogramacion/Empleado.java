package programacion.empresaprogramacion;

public abstract class Empleado implements Comparable<Empleado>{
  private String dniEmpleado;
  private String nombre;
  private Double sueldo;
  static final String REGEX_DNI = "^[0-9]{5,8}[A-Z]{1}$";

  
  /**
   * @param dniEmpleado
   * @param nombre
   * @param sueldo he cambiado a la wrapper class para luego no tener problemas con la lista ordenada por sueldo.
   */
  public Empleado(String dniEmpleado, String nombre, Double sueldo) throws ParametroInvalidoException{
    if(dniEmpleado.isEmpty() || !dniEmpleado.matches(REGEX_DNI)){
      throw new ParametroInvalidoException("Dni no válido:" + dniEmpleado);
    }
    this.dniEmpleado = dniEmpleado;
    if(nombre.isEmpty()){
      throw new ParametroInvalidoException("Nombre vacío.");
    }
    this.nombre = nombre;
    if(sueldo < 900){
      throw new ParametroInvalidoException("Debes estar de broma." + sueldo + "no pagan el alquiler.");
    }
    this.sueldo = sueldo;
  }

  @Override
  public String toString() {
    return "Empleado [dniEmpleado=" + dniEmpleado + ", nombre=" + nombre + ", sueldo=" + sueldo + ", ";
  }

  public String getDniEmpleado() {
    return dniEmpleado;
  }

  public String getNombre() {
    return nombre;
  }

  public Double getSueldo() {
    return sueldo;
  }

  @Override
  public int compareTo(Empleado o) {
    return this.getNombre().compareTo((o.getNombre())); //no sé si el this está feo. O sea sobra, pero aclara o ensucia?
  }




  
}
