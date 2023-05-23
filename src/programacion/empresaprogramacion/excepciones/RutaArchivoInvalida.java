package programacion.empresaprogramacion.excepciones;

public class RutaArchivoInvalida extends Throwable{
  public RutaArchivoInvalida(String mensajeError) {
    super(mensajeError);
  }
}
