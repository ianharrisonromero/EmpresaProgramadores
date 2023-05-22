package programacion.empresaprogramacion;
import java.lang.Exception;
class ParametroInvalidoException extends Exception {
  public ParametroInvalidoException(String mensaje) {
      super(mensaje);
  }
}
