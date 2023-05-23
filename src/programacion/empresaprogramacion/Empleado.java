package programacion.empresaprogramacion;

import programacion.empresaprogramacion.excepciones.ParametroInvalidoException;

import java.util.Comparator;

public abstract class Empleado{
  final String DNI;
  final String NOMBRE;
  Double sueldo;
  TipoEmpleado tipoEmpleado;
  static final String REGEX_DNI = "^[0-9]{8}[A-Z]$";
  static final Comparator<Empleado> COMPARATOR_SUELDO = new Comparator<>() {
    @Override
    public int compare(Empleado o1, Empleado o2) {
      return o1.sueldo.compareTo(o2.sueldo);
    }
  };
  static final Comparator<Empleado> COMPARATOR_NOMBRE = new Comparator<>() {
    @Override
    public int compare(Empleado o1, Empleado o2) {
      return o1.NOMBRE.compareTo(o2.NOMBRE);
    }
  };

  public Empleado(String DNI,
                  String nombre,
                  Double sueldo,
                  TipoEmpleado tipoEmpleado) throws ParametroInvalidoException {
    if(DNI.matches(REGEX_DNI) && checkValidezDNI(DNI)){
      this.DNI = DNI;
    }else{
        throw new ParametroInvalidoException("DNI no válido: El DNI '" + DNI
                + (!DNI.matches(REGEX_DNI) ? "' no cumple el patrón de 8 números y una letra mayúscula al final.\n" :
                (checkValidezDNI(DNI) ? "' no cumple el patrón de 8 números y una letra mayúscula al final.\n" :
                        "' no tiene una letra válida.\n")));
    }
    if(!(nombre.length() < 2)){
        this.NOMBRE = nombre;
    }else {
      throw new ParametroInvalidoException("Nombre no válido: "+nombre+" no tiene la longitud mínima de 2 caracteres.\n");
    }
    if (sueldo >= 0){
      this.sueldo = sueldo;
    }else{
        throw new ParametroInvalidoException("Sueldo no válido: "+sueldo+" no puede ser negativo.\n");
    }
    this.tipoEmpleado = tipoEmpleado;
  }

  public abstract String toCsvLine();

  @Override
  public String toString() {
    return String.format("%s - %s - %.2f%s", DNI, NOMBRE, sueldo, "€");
  }

  private boolean checkValidezDNI(String DNI){
    int numero = Integer.parseInt(DNI.substring(0,8));
    char letra = DNI.charAt(8);
    return letra == "TRWAGMYFPDXBNJZSQVHLCKE".charAt(numero%23);
  }
}
