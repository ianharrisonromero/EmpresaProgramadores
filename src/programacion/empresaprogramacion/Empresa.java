package programacion.empresaprogramacion;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Empresa {
    
    public String nombre;
    public Map<String, Empleado> mapaEmpleados;
    static final String FICHERO = "Fichero.txt";
    static final String REGEX = ",";


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

    public void guardarEnCSV() {
        try (FileWriter escritor = new FileWriter(FICHERO, true)) {
            escritor.write(this.toString());
        } catch (Exception e) {
            System.out.println("Error al escribir en fichero. " + e.getMessage());
        }
    }

    public void cargarDesdeCSV(String archivoCargar) {
        try (BufferedReader lector = new BufferedReader(new FileReader(FICHERO))) {
            String linea ="";//sigo dudando si solo instanciarlo sin inicializar...
            while((linea = lector.readLine()) != null){
                System.out.println(linea);
                String [] atributos = linea.split(REGEX);
                try{
                    //cómo diferenciar progs de gerentes si solo hago una lista? 
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ficher no encontrado: " + e.getMessage());
        } catch (IOException e){
            System.out.println("Error al leer: " + e.getMessage());
        }

    }
    @Override
    public String toString() {
        return "Empresa " + nombre + ", Empleados= " + mapaEmpleados.values();
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
        List<Empleado> ordenadosPorSueldo = new ArrayList<>(mapaEmpleados.values());
        String devolucion = "";
        Collections.sort(ordenadosPorSueldo, Empleado.COMPARATOR_SUELDO.reversed());
        for (Empleado emple : ordenadosPorSueldo) {
         devolucion += " " + emple.getNombre();    
        }
        return devolucion;
    }

    public String toStringOrdenNombre() {
        List<Empleado> ordenadosPorNombre = new ArrayList<>(mapaEmpleados.values());
        String devolucion = "";
        Collections.sort(ordenadosPorNombre);
        for(Empleado emple : ordenadosPorNombre){
            devolucion += " " + emple.getNombre();
        }
        return devolucion;
    }



}
