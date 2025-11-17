package ed.u2.sorting;

public final class InsertionSort {

    // Contador de movimientos (se reinicia cada vez que se llama sort)
    private static int movimientos;

    public static int getMovimientos() {
        return movimientos;
    }

    public static void sort(int[] a) {
        sort(a, false);
    }

    public static void sort(int[] a, boolean trace) {
        movimientos = 0;

        if (a == null || a.length <= 1) return;

        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;

            if (trace) {
                System.out.println("---- Iteración i=" + i + " ----");
                System.out.println("Elemento a insertar: " + key);
            }

            // Desplazamientos
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                movimientos++;

                if (trace) {
                    System.out.println("Mover a[" + j + "] -> a[" + (j + 1) + "]");
                    imprimirArreglo(a);
                }

                j--;
            }

            // Inserción final
            a[j + 1] = key;
            movimientos++;

            if (trace) {
                System.out.println("Insertar key en posición " + (j + 1));
                imprimirArreglo(a);
            }
        }
    }

    private static void imprimirArreglo(int[] a) {
        System.out.print("[ ");
        for (int x : a) System.out.print(x + " ");
        System.out.println("]");
    }
}
