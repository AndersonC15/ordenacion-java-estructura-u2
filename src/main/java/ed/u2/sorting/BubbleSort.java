/**
 * Clase BubbleSort:
 * Implementa el algoritmo de ordenación Burbuja.
 * Incluye la optimización de "corte temprano", que detiene el algoritmo
 * si en una pasada no se realiza ningún intercambio (swaps).
 * Ideal para arreglos pequeños o casi ordenados.
 */

package ed.u2.sorting;

public final class BubbleSort {

    // Método principal de ordenación
    public static void sort(int[] a) {
        sort(a, false);
    }

    // Versión con trazas activables
    public static void sort(int[] a, boolean trace) {
        int n = a.length;
        int totalSwaps = 0;

        if (trace) {
            System.out.println("=== BUBBLE SORT ===");
        }

        // Pasadas del algoritmo
        for (int pass = 0; pass < n - 1; pass++) {
            boolean swapped = false;     // Para verificar si hubo cambios
            int swapsThisPass = 0;

            // Comparación de pares adyacentes
            for (int j = 0; j < n - 1 - pass; j++) {
                if (a[j] > a[j + 1]) {
                    // Intercambio de elementos
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;

                    swapped = true;
                    swapsThisPass++;
                    totalSwaps++;

                    if (trace) {
                        System.out.println("swap -> " + SortingUtils.toString(a));
                    }
                }
            }

            // Mostrar resumen de la pasada
            if (trace) {
                System.out.println("pasada " + pass + " | swaps = " + swapsThisPass);
            }

            // Corte temprano si no hubo swaps
            if (!swapped) {
                if (trace) System.out.println("No hubo swaps → corte temprano");
                break;
            }
        }

        if (trace) {
            System.out.println("\nTotal swaps = " + totalSwaps);
        }
    }
}
