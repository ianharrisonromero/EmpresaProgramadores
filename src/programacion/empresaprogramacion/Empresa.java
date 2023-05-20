package programacion.empresaprogramacion;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nombre;
    private List<Empleado> empleados;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public void addEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void guardarEnCSV(String archivoGuardar) {
        //TODO 
    }

    public void cargarDesdeCSV(String archivoCargar) {
        //TODO
    }

    @Override
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
