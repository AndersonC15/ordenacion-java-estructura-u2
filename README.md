# Ordenacion-java-estructura-u2

### InsertionSort
**InsertionSort** es un algoritmo de ordenación *in-place* y **estable** que inserta cada elemento en su posición correcta dentro del subarreglo ya ordenado.
El mejor caso posible es :0(n), el peor caso posible es 0(n²) y si llega a ser estable y tambien es In-place.

#### ¿Cómo funciona?
1. El recorrido inicia en la posición 1.
2. Se toma el valor actual.
3. Se comparan los elementos anteriores mientras sean mayores.
4. Cada vez que se mueve un elemento hacia la derecha cuenta como un **movimiento**.
5. Finalmente se inserta el valor en la posición correcta.

#### ¿Cuándo es eficiente?
Llega hacer eficiente cuando los arreglos son pequeños, los datos estan casi ordenador y cuando hay muy poca memoria adicional.

---

### SelectionSort
**SelectionSort** selecciona el valor **mínimo** en cada iteración y lo intercambia con la posición actual utilizando un único **swap**.
Es complejo cuando todos los casos son O(n²), no es estable pero si tiene In-place y por ultimo se utiliza pocos swaps.

#### ¿Cómo funciona?
1. Para cada posición `i`, se busca el índice del valor mínimo.
2. Al finalizar la búsqueda, se realiza un **solo intercambio**.
3. Continúa hasta ordenar todo el arreglo.

#### ¿Cuándo es eficiente?
Es eficiente cuando los intercambios son costosos, se realiza como maximo **n - 1 swaps** y es simple, directo y fácil de analizar.

---

### Definiciones (Movimiento / Swap)

#### Movimiento (InsertionSort)
Un movimiento ocurre cuando un elemento se copia de una posición a otra y cada copia incrementa el contador de movimientos.:

```java

arreglo[j + 1] = arreglo[j];

```

#### Swap (SelectionSort)

Un swap es un intercambio entre dos posiciones y cada intercambio incrementa el contador de swaps:

```java
temporal = arreglo[i];
arreglo[i] = arreglo[min];
arreglo[min] = temporal;

```
