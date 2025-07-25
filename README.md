# UNPAZ - Cursos y Estudiantes: Gestión de Cursos y Alumnos

Este proyecto en Java gestiona cursos y estudiantes, permitiendo la creación de diferentes tipos de cursos, la lectura de datos desde archivos, y la interacción con los usuarios para la gestión de cursos.

---

## 1. Clases e Interfaces

### Clases

* **`Curso`** (Clase Abstracta)
    * **Atributos:**
        * `nombre del curso` (String)
        * `cantidad de horas` (int)
        * `precio base` (double)
    * **Métodos Abstractos:**
        * `double calcularPrecioFinal()`: Calcula el precio final del curso.
        * `String resumen()`: Proporciona un resumen del curso.

* **`CursoEnVivo`** (Subclase de `Curso`)
    * **Atributo Adicional:**
        * `cantidadDeClasesEnVivo` (int)
    * **Cálculo de Precio Final:** `precio base + ($100 * cantidadDeClasesEnVivo)`

* **`CursoGrabado`** (Subclase de `Curso`)
    * **Atributo Adicional:**
        * `cantidadDeModulosGrabados` (int)
    * **Cálculo de Precio Final:** `precio base + ($50 * cantidadDeModulosGrabados)`

* **`Estudiante`**
    * **Atributos:**
        * `nombreCompleto` (String)
        * `email` (String): Debe validar un formato simple que contenga `'@'`.
    * **Método:**
        * `String identificador()`: Devuelve el email del estudiante como su identificador.

### Interfaces

* **`Facturable`**
    * `double getMonto()`: Devuelve un monto facturable.

* **`Identificable`**
    * `String getIdentificador()`: Devuelve un identificador único.

**Nota:** Las clases `Curso` (o sus subclases) deben implementar estas interfaces (`Facturable` e `Identificable`).

---

## 2. Lectura desde Archivo

Los cursos se leerán desde un archivo `cursos.csv`. Cada línea de este archivo debe tener el siguiente formato:

**Ejemplos:**
```csv
tipoCurso;nombre;horas;precioBase;clasesOModulos
GRABADO;Python desde novato;20;50000;4
ENVIVO;Java avanzado;30;20000;10
```


## 3. Funcionalidades Obligatorias

* **Almacenamiento de Cursos:** Leer y almacenar todos los cursos del archivo `cursos.csv` en una colección (`List<Curso>`).
* **Mostrar Precios y Resúmenes:** Recorrer la colección de cursos y mostrar el precio final junto con el resumen de cada uno.
* **Curso Más Caro:** Identificar y mostrar el curso con el precio final más alto.
* **Búsqueda de Cursos:** Permitir al usuario buscar cursos por nombre, aceptando búsquedas parciales (no es necesario que el nombre sea exacto).
* **Agrupación por Tipo:** Agrupar los cursos en un `Map<String, List<Curso>>` donde la clave sea el tipo de curso (`"GRABADO"` o `"ENVIVO"`) y el valor sea una lista de cursos de ese tipo. Luego, mostrar los resultados de esta agrupación.
* **Agregar Curso desde Consola:** Permitir al usuario agregar un nuevo curso ingresando sus datos por consola y luego guardar este nuevo curso en el archivo `cursos.csv`.

---

## 4. Bonus (Opcional)

* **`EmailInvalidadoException`:** Crear una excepción personalizada `EmailInvalidadoException` que se lance cuando se intente instanciar un objeto `Estudiante` con un formato de email incorrecto.
* **Inscripción de Estudiantes:** Desarrollar un método que permita inscribir estudiantes en cursos. Luego, mostrar qué estudiantes están inscritos en cada curso, utilizando un `Map<Curso, List<Estudiante>>`.
