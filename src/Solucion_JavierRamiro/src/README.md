# Enunciado: Empresa de Programadores y Gerentes

En este ejercicio, se te proporciona un programa principal llamado `MainEmpresa` que interactúa con una clase llamada `Empresa`. Tu tarea es crear e implementar las siguientes clases: `Empleado` (abstracta), `Gerente`, `Programador`, `ParametroInvalidoException` y `TipoEmpleado` (enum). A continuación, se detalla cada una de las clases:

## Empleado (abstracta):

- Atributos:
  - `nombre` (String): el nombre del empleado.
  - `sueldo` (double): el sueldo del empleado.

- Métodos:
  - `Constructor`: recibe el nombre y el sueldo del empleado.
  - `getNombre()`: devuelve el nombre del empleado.
  - `getSueldo()`: devuelve el sueldo del empleado.
  - `toString()`: devuelve una representación en cadena de caracteres del empleado.

## Gerente (subclase de Empleado):

- Atributos:
  - `departamento` (String): el departamento del gerente.

- Métodos:
  - `Constructor`: recibe el nombre, el sueldo y el departamento del gerente.
  - `getDepartamento()`: devuelve el departamento del gerente.
  - `toString()`: devuelve una representación en cadena de caracteres del gerente.

## Programador (subclase de Empleado):

- Atributos:
  - `lenguaje` (String): el lenguaje de programación del programador.
  - `plusIdioma` (boolean): indica si el programador recibe un plus de idioma o no.

- Métodos:
  - `Constructor`: recibe el nombre, el sueldo, el lenguaje de programación y el estado del plus de idioma del programador.
  - `getLenguaje()`: devuelve el lenguaje de programación del programador.
  - `recibePlusIdioma()`: devuelve true si el programador recibe un plus de idioma, false en caso contrario.
  - `toString()`: devuelve una representación en cadena de caracteres del programador.

## ParametroInvalidoException (clase de excepción):

- Hereda de la clase `Exception`.
- `Constructor`: recibe un mensaje de error como parámetro.

## TipoEmpleado (enum):

- Enumerados:
  - `GERENTE`: representa el tipo de empleado gerente.
  - `PROGRAMADOR`: representa el tipo de empleado programador.

Implementa las clases mencionadas anteriormente con sus respectivos atributos y métodos según las especificaciones proporcionadas.

Una vez implementadas las clases, intégralas en el programa `MainEmpresa` proporcionado. Asegúrate de completar las partes indicadas con `// TODO` en el código.

El programa debe realizar las siguientes acciones:

- Imprimir todos los empleados.
- Imprimir solo los programadores.
- Imprimir los empleados por sueldo de mayor a menor.
- Imprimir los empleados por nombre en orden alfabético.
- Cargar datos de empleados desde un archivo CSV.
- Guardar los datos de empleados en un archivo CSV.
- Salir del programa.

Realiza la acción correspondiente según la opción seleccionada por el usuario. Recuerda manejar las excepciones apropiadas y validar los datos ingresados por el usuario.
