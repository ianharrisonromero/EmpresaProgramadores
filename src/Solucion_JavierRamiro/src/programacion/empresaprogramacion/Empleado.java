package programacion.empresaprogramacion;
    public abstract class Empleado {
        private String nombre;
        protected static double sueldo;
    
        public Empleado(String nombre, double sueldo) {
            this.nombre = nombre;
        }
    
        public String getNombre() {
            return nombre;
        }
    
        public double getSueldo() {
            return sueldo;
        }
    
        public abstract TipoEmpleado getTipo();
    
        @Override
        public String toString() {
            return "Empleado [nombre=" + nombre + ", sueldo=" + sueldo + "]";
        }
    }
