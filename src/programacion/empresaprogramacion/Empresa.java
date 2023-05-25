package programacion.empresaprogramacion;
import java.util.Map;
import java.util.TreeMap;

public class Empresa {
    
    public String nombre;
    public Map<String, Empleado> mapaEmpleados;
    static final String FICHERO = "Fichero.txt";


    public Empresa(String nombre) {
        this.nombre = nombre;
        this.mapaEmpleados = new TreeMap<String, Empleado>();
    }

    public void addEmpleado(Empleado empleado) throws ParametroInvalidoException{
        if(mapaEmpleados.containsKey(empleado.getDniEmpleado())){
            throw new ParametroInvalidoException("Dni duplicado: " + empleado.getDniEmpleado());
        }
        mapaEmpleados.put(empleado.getDniEmpleado(), empleado);
    }

    public void guardarEnCSV(String archivoGuardar) {
        //TODO 
    }

    public void cargarDesdeCSV(String archivoCargar) {
        //TODO

    }
    @Override
    public String toString() {
        return "Empresa " + nombre + ", mapaEmpleados=" + mapaEmpleados.values();
    }


    public String toStringEmpleados() {
        String cadena="";
        for (String key : mapaEmpleados.keySet()) {
            cadena += key + " -> " + mapaEmpleados.get(key);
        }
        return cadena;
    }

    public String toStringProgramadores() {
        String cadena="";
        for (String key : mapaEmpleados.keySet()) {
            if(mapaEmpleados.get(key) instanceof Programador){
                cadena += key + " -> " + mapaEmpleados.get(key);
            }
        }
        return cadena;
    }

    public String toStringOrdenSueldo() {
        // TODO ordenar todos los empleados por orden de sueldo de MAYOR A MENOR,
        // mostrándolo
    }

    public String toStringOrdenNombre() {
        // TODO ordenar todos los empleados por orden de nombre alfabético, mostrándolo
    }



}
