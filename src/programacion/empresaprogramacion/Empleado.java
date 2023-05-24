package programacion.empresaprogramacion;

import java.util.Comparator;

public abstract class Empleado {
  private String dniEmpleado;
  private String nombre;
  private Double sueldo;
  private TipoEmpleado tipo;
  static final String EMPLEADO_CSV_HEADER = "DNI,NOMBRE,SUELDO,TIPO";

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

  public Empleado(String dniEmpleado, String nombre, double sueldo, TipoEmpleado tipo) {
    this.dniEmpleado = dniEmpleado;
    this.nombre = nombre;
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

  public TipoEmpleado getTipo(){
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
