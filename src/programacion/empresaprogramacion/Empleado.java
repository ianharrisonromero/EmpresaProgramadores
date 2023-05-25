package programacion.empresaprogramacion;

import java.util.Comparator;

public abstract class Empleado {
  private String dniEmpleado;
  private String nombre;
  private Double sueldo;
  private TipoEmpleado tipo;
  static final String EMPLEADO_CSV_HEADER = "DNI,NOMBRE,SUELDO,TIPO";
  static final String DNI_REGEX = "^[0-9]{8}[A-Z]$";

  public static final Comparator<Empleado> COMPARATOR_SUELDO = new Comparator<Empleado>() {
    public int compare(Empleado emp1, Empleado emp2) {
      return emp1.sueldo.compareTo(emp2.sueldo);
    };
  };

  public static final Comparator<Empleado> COMPARATOR_NOMBRE = new Comparator<Empleado>() {

    @Override
    public int compare(Empleado emp1, Empleado emp2) {
      return emp1.nombre.compareTo(emp2.nombre);
    }

  };

  public Empleado(String dniEmpleado, String nombre, double sueldo, TipoEmpleado tipo)
      throws ParametroInvalidoException {
    if (dniEmpleado.matches(DNI_REGEX)) {
      this.dniEmpleado = dniEmpleado;
    } else {
      throw new ParametroInvalidoException("El DNI " + dniEmpleado + "no tiene el formato correcto");
    }
    if (nombre.isEmpty()) {
      throw new ParametroInvalidoException("El nombre no puede estar vacío.");
    }
    if (nombre.length()<2) {
      throw new ParametroInvalidoException("El nombre tiene que tener al menos 2 caracteres");
    }
    this.nombre = nombre;
    if (sueldo<1080) {
      throw new ParametroInvalidoException("El sueldo tiene que ser al menos de 1080 euros.");
    }
    this.sueldo = sueldo;
    this.tipo = tipo;
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

  public TipoEmpleado getTipo() {
    return tipo;
  }

  public void setDniEmpleado(String dniEmpleado) {
    this.dniEmpleado = dniEmpleado;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setSueldo(Double sueldo) {
    this.sueldo = sueldo;
  }

  public void setTipo(TipoEmpleado tipo) {
    this.tipo = tipo;
  }

  @Override
  public String toString() {
    return dniEmpleado + ", " + nombre + ", " + sueldo + ", " + tipo;
  }

  public abstract String toCsvLine();

}
