package programacion.empresaprogramacion;
import java.util.Comparator;

public abstract class Empleado implements Comparable<Empleado> {
  private String idEmpleado;
  private String nombre;
  private double sueldo;
  private TipoEmpleado tipo;
  private final static String idEmpleadoRegexp = "[A-Z]8[0-9]{3}";

  public static final Comparator<Empleado> COMPARATOR_SUELDO = new Comparator<Empleado>() {
    @Override
    public int compare(Empleado o1, Empleado o2) {
      // Compara sueldos, se usará para ordenarlos por dicha caracteristica
      Double sueldo1 = Double.valueOf(o1.sueldo);
      Double sueldo2 = Double.valueOf(o2.sueldo);
      return sueldo1.compareTo(sueldo2);
    }
  };

  public int compareTo(Empleado o) {
    // Compara nombres, se usará para ordenarlos alfabeticamente
    return nombre.compareTo(o.nombre);
  }

  public Empleado(String idEmpleado, String nombre, double sueldo, TipoEmpleado tipo)
      throws ParametroInvalidoException {
    if (nombre.isEmpty()) {
      // Comprueba que el nombre no esté vacio
      throw new ParametroInvalidoException("El nombre esta vacio.");
    }
    this.nombre = nombre;
    if (sueldo < 0) {
      // Comprueba que el sueldo no sea menor a 0
      throw new ParametroInvalidoException("El sueldo es menor a 0.");
    }
    this.sueldo = sueldo;
    if (!idEmpleado.matches(idEmpleadoRegexp)) {
      // Comprueba id cumpla el patrón
      throw new ParametroInvalidoException("El id introducido contiene caracteres no soportados .");
    }

    this.idEmpleado = idEmpleado;
    this.tipo = tipo;
  }
  
  public String getIdEmpleado() {
    return idEmpleado;
  }

  /* NO SE USA
  public String getNombre() {
    return nombre;
  }

  public double getSueldo() {
    return sueldo;
  }
  */
  public TipoEmpleado getTipo() {
    return tipo;
  }
  
  @Override
  public String toString() {
    // Metodo toString padre que heredaran la clase Programador y Gerente
    return "ID Empleado: " + idEmpleado + ", Nombre: " + nombre + ", sueldo: " + sueldo;
  }


}
