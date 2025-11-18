# Ordenacion-java-estructura-u2

Este proyecto implementa y compara tres algoritmos de ordenación in-place utilizando Java: InsertionSort, SelectionSort y BubbleSort.
El objetivo es ordenar arreglos pequeños, analizar su comportamiento, generar trazas, probar casos borde y comparar movimientos y swaps.

## Objetivos de la práctica:

Implementar los algoritmos de ordenación: Inserción, Selección y Burbuja.
Comparar su funcionamiento mediante trazas, movimientos, intercambios y casos de prueba reproducibles.
Comprender cuándo es más eficiente cada algoritmo.

Utilizar buenas prácticas: código limpio, pruebas, README y Git.
---
Estructura sugerida del proyecto

```java
src/
└── main/java/ed/u2/sorting/
├── InsertionSort.java
├── SelectionSort.java
├── BubbleSort.java
├── SortingDemo.java
└── SortingUtils.java
```
Todas las clases de ordenación se encuentran en el paquete ed.u2.sorting:

- InsertionSort.java: Implementación del algoritmo de ordenación por inserción.

- SelectionSort.java: Implementación del algoritmo de ordenación por selección.

- BubbleSort.java: Implementación del algoritmo de ordenación burbuja.

- SortingDemo.java: Clase principal para demostrar y probar los algoritmos.

SortingUtils.java: Utilidades auxiliares para imprimir arrays y validar ordenación
---
## Como ejecutar el programa:
Para compilar el programa, navega a la raíz del proyecto y ejecuta javac src/main/java/ed/u2/sorting/*.java. Esto compilará todos los archivos de los algoritmos de ordenación.

Para ejecutar el programa, usa java -cp src/main/java ed.u2.sorting.SortingDemo. Este comando ejecutará la clase principal que muestra los resultados de los tres algoritmos con diferentes casos de prueba.

Y como consejo asegurate de que la estructura de carpetas coincida con los paquetes Java y que todos los archivos tengan la declaración correcta package ed.u2.sorting.

---

## Algoritmos implementados:

### InsertionSort:

InsertionSort es un algoritmo de ordenación in-place y estable. Inserta cada elemento en el subarreglo previo ya ordenado.

- Mejor caso: O(n)

- Peor caso: O(n²)

- Estable: ✔

- In-place: ✔

### ¿Cómo funciona?

Se recorre desde i = 1 hasta n - 1. Despues toma el elemento actual.
Se compara con los anteriores mientras sean mayores.
Cada desplazamiento cuenta como movimiento.
Se inserta en su posición correcta.

## ¿Cuándo es eficiente?

Cuando los datos están casi ordenados, tambien cuando el arreglo es pequeño y si hay poca memoria disponible.

```java
Movimiento (InsertionSort)
arreglo[j + 1] = arreglo[j];
```
---

### SelectionSort:

SelectionSort selecciona el valor mínimo en cada iteración y luego realiza un solo swap.

Complejidad: O(n²) en todos los casos

Estable: ✘

In-place: ✔

Swaps: muy pocos (máx. n - 1)

---

## ¿Cómo funciona?

Para cada índice i, buscar el mínimo entre i..n-1.

Realizar un único intercambio y avanza hasta ordenar todo el arreglo.

---
v
## ¿Cuándo es eficiente?

Cuando los swaps son costosos. tambien cuando interesa minimizar intercambios y si se llega a requerir de simplicidad.

```java
Swap (SelectionSort)
temporal = arreglo[i];
arreglo[i] = arreglo[min];
arreglo[min] = temporal;
```
---

### BubbleSort:

BubbleSort compara elementos adyacentes y los intercambia si están desordenados.Incluye corte temprano, optimizando el mejor caso a O(n).

- Complejidad: O(n²)

- Estable: ✔

- In-place: ✔

## ¿Cómo funciona?

Comparar pares adyacentes e intercambiar si es necesario, se debe repetir pasadas y si en una pasada no hay swaps → termina antes.

## ¿Cuándo es eficiente?

Cuando hay areglos muy pequeños y los datos estan casi ordenados.

---

### Casos de prueba requeridos:

```java
Nombre	Arreglo	        Orden esperado
A	[8, 3, 6, 3, 9]	[3, 3, 6, 8, 9]
B	[5, 4, 3, 2, 1]	[1, 2, 3, 4, 5]
C	[1, 2, 3, 4, 5]	[1, 2, 3, 4, 5]
D	[2, 2, 2, 2]	[2, 2, 2, 2]
E	[9, 1, 8, 2]	[1, 2, 8, 9]
```
---
# Preguntas de control:

- ¿Por qué Inserción es preferible con datos casi ordenados?
Porque en el mejor caso (arreglo ya ordenado) tiene complejidad O(n).

- ¿Qué propiedad hace que Selección use pocos swaps? ¿Qué compromisos tiene?
Realiza exactamente n-1 intercambios, pero siempre tiene complejidad O(n²).

- ¿Cómo implementarías el corte temprano en Burbuja y qué caso reduce significativamente?
Con un flag que detecte si hubo intercambios en una pasada. Mejora el mejor caso a O(n).

- ¿Cuál(es) de los tres puede(n) ser estable y en qué condiciones?
Inserción y Burbuja son estables. Selección no es estable por defecto.

- Menciona dos casos borde que deben probarse siempre.
Arreglo vacío y arreglo con un solo elemento.

---

# Casos borde verificados:
- Arreglo vacío []
- Arreglo de un elemento [5]
- Todos los elementos iguales [2,2,2,2]
- Arreglo ya ordenado [1,2,3,4,5]
- Arreglo en orden inverso [5,4,3,2,1]
- Arreglo con duplicados [8,3,6,3,9]

---

## Observaciones cualitativas:

- Inserción demuestra mayor eficiencia cuando los datos están parcialmente ordenados, ya que en el mejor caso alcanza complejidad lineal O(n). Sin embargo, su rendimiento decae significativamente con arreglos desordenados o en orden inverso, donde realiza numerosos desplazamientos. Es una opción ideal para conjuntos pequeños de datos o cuando se prioriza la estabilidad del algoritmo.

- Selección se caracteriza por realizar una cantidad mínima de intercambios (n-1 como máximo), lo que lo hace adecuado cuando las operaciones de swap son computacionalmente costosas. Su principal limitación es que mantiene una complejidad cuadrática O(n²) en todos los escenarios y no preserva el orden relativo de elementos iguales, siendo inestable por naturaleza.

- Burbuja, a pesar de su simplicidad conceptual, resulta ineficiente para la mayoría de casos prácticos. La implementación del corte temprano mejora su comportamiento en arreglos casi ordenados, reduciendo el mejor caso a O(n). Su principal valor didáctico reside en la facilidad para entender el proceso de ordenación mediante comparaciones de elementos adyacentes.

---
## Información de entrega:
- Fecha de entrega: Jueves 13 - Viernes 14 de noviembre
- Docente: Andrés Roberto Navas Castellanos
- Asignatura: Estructura de Datos - Ciclo 3A
