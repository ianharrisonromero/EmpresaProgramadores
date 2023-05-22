package programacion.empresaprogramacion;
import java.util.Map;

public class Empresa {
    
    public String nombre;
    public Map<Integer, Empleado> mapaEmpleados;

    //AHORA ESTOY EN BRANCH MAIN

    public Empresa(String nombre) {
        this.nombre = nombre;
        //TODO this.empleados = new ?<>();
    }

    public void addEmpleado(Empleado empleado) {
        // TODO  (no permitir meter 2 empleados con el mismo "idEmpleado" y dado el caso lanzar 
        //exception)
    }

    public void guardarEnCSV(String archivoGuardar) {
        //TODO 
    }

    public void cargarDesdeCSV(String archivoCargar) {
        //TODO

    }
    @Override
    public String toString() {
        //TODO dejar el toString bonito
        return "Empresa [nombre=" + nombre + ", mapaEmpleados=" + mapaEmpleados + "]";
    }


    public String toStringEmpleados() {
        // TODO Mostrar todos los datos de la empresa (nombre y empleados)

    }

    public String toStringProgramadores() {
        // TODO mostrar todos los empleados programadores, y si reciben o no plus de
        // idioma

    }

    public String toStringOrdenSueldo() {
        // TODO ordenar todos los empleados por orden de sueldo de MAYOR A MENOR,
        // mostrándolo
    }

    public String toStringOrdenNombre() {
        // TODO ordenar todos los empleados por orden de nombre alfabético, mostrándolo
    }

}
