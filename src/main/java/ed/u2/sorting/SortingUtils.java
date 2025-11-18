/**
 * Clase SortingUtils:
 * Contiene funciones auxiliares usadas por los algoritmos.
 * Incluye métodos para copiar arreglos y convertirlos a String.
 */

package ed.u2.sorting;

import java.util.Arrays;

public final class SortingUtils {

    // Convertir arreglo a String con formato [a, b, c]
    public static String toString(int[] a) {
        return Arrays.toString(a);
    }

    // Copiar un arreglo para evitar modificar el original
    public static int[] copy(int[] a) {
        return Arrays.copyOf(a, a.length);
    }
}
