/**
 * Clase InsertionSort:
 * Implementa el algoritmo de ordenación por inserción.
 * Este método es muy eficiente cuando el arreglo está casi ordenado.
 * Además, genera trazas mostrando cada movimiento realizado.
 */

package ed.u2.sorting;

public final class InsertionSort {

    private static int contadorMovimientos;  // Contador de movimientos internos

    public static int getContadorMovimientos() {
        return contadorMovimientos;
    }

    public static void sort(int[] arreglo) {
        sort(arreglo, false);
    }

    // Versión con trazas
    public static void sort(int[] arreglo, boolean trazar) {

        contadorMovimientos = 0;

        if (arreglo == null || arreglo.length <= 1) return;

        // Comenzar desde la posición 1
        for (int indiceActual = 1; indiceActual < arreglo.length; indiceActual++) {

            int valorAInsertar = arreglo[indiceActual];
            int indiceComparacion = indiceActual - 1;

            if (trazar) {
                System.out.println("---- Iteración indiceActual =" + indiceActual + " ----");
                System.out.println("Valor a insertar: " + valorAInsertar);
            }

            // Desplazar los elementos mayores hacia la derecha
            while (indiceComparacion >= 0 && arreglo[indiceComparacion] > valorAInsertar) {

                arreglo[indiceComparacion + 1] = arreglo[indiceComparacion];
                contadorMovimientos++;

                if (trazar) {
                    System.out.println("Mover arreglo[" + indiceComparacion + "] -> arreglo[" + (indiceComparacion + 1) + "]");
                    imprimirArreglo(arreglo);
                }
                indiceComparacion--;
            }

            // Insertar el valor en su posición final
            arreglo[indiceComparacion + 1] = valorAInsertar;
            contadorMovimientos++;

            if (trazar) {
                System.out.println("Insertar valor en posición " + (indiceComparacion + 1));
                imprimirArreglo(arreglo);
            }
        }
    }

    private static void imprimirArreglo(int[] arreglo) {
        System.out.print("[ ");
        for (int numero : arreglo)
            System.out.print(numero + " ");
        System.out.println("]");
    }
}
