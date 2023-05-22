package programacion.empresaprogramacion;

public class Programador extends Empleado {
  private boolean esJunior;
  private String lenguaje;
  private boolean plusIdioma;

  public Programador(String idEmpleado, String nombre, double sueldo, String lenguaje,
      boolean esJunior, boolean plusIdioma) throws ParametroInvalidoException {
    super(idEmpleado, nombre, sueldo, TipoEmpleado.PROGRAMADOR);

    this.esJunior = esJunior;

    if (lenguaje.isEmpty()){
      // Comprueba que el campo lenguaje no esté vacio
      throw new ParametroInvalidoException("Nombre lenguaje vacio.");
    }
    this.lenguaje = lenguaje;

    this.plusIdioma = plusIdioma;
  }

  public String esJunior() {
    //Metodo para devolver la cadena mediante un boolean, mejor hacerlo con operador ternario
    if (esJunior) {
      return "es junior";
    } else
      return "NO es junior";
  }

  /* NO SE USA
  public String getLenguaje() {
    return lenguaje;
  }
  */

  @Override
  public String toString() {
    //Sobrescribimos el metodo toString de la clase Empleado
    return "|Programador|" + super.toString() + ", " + "Lenguaje: " + lenguaje + ", " + esJunior() + ", "
        + (plusIdioma ? "recibe plus de idioma" : "NO recibe plus de idioma");
  }

}

