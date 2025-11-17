package ed.u2.sorting;

public final class SelectionSort {

    // Contador de intercambios (swaps)
    private static int contadorIntercambios;

    public static int getContadorIntercambios() {
        return contadorIntercambios;
    }

    public static void sort(int[] arreglo) {
        sort(arreglo, false);
    }

    public static void sort(int[] arreglo, boolean trazar) {

        contadorIntercambios = 0;

        if (arreglo == null || arreglo.length <= 1) return;

        for (int posicionActual = 0; posicionActual < arreglo.length - 1; posicionActual++) {

            int indiceMinimo = posicionActual;

            if (trazar) {
                System.out.println("---- Iteración posicionActual=" + posicionActual + " ----");
                System.out.println("Buscando mínimo desde índice " + posicionActual);
            }

            // Buscar el valor mínimo en el subarreglo restante
            for (int posicionBusqueda = posicionActual + 1; posicionBusqueda < arreglo.length; posicionBusqueda++) {

                if (trazar) {
                    System.out.println("Comparando arreglo[" + posicionBusqueda + "]=" + arreglo[posicionBusqueda] +
                            " con arreglo[" + indiceMinimo + "]=" + arreglo[indiceMinimo]);
                }

                if (arreglo[posicionBusqueda] < arreglo[indiceMinimo]) {
                    indiceMinimo = posicionBusqueda;

                    if (trazar) {
                        System.out.println("→ Nuevo mínimo encontrado en posición " + posicionBusqueda);
                    }
                }
            }

            // Intercambio si el mínimo no está en la posición correcta
            if (indiceMinimo != posicionActual) {

                int temporal = arreglo[posicionActual];
                arreglo[posicionActual] = arreglo[indiceMinimo];
                arreglo[indiceMinimo] = temporal;

                contadorIntercambios++;

                if (trazar) {
                    System.out.println("Intercambio entre posiciones " + posicionActual + " y " + indiceMinimo);
                    imprimirArreglo(arreglo);
                }
            }
        }
    }

    private static void imprimirArreglo(int[] arreglo) {
        System.out.print("[ ");
        for (int numero : arreglo) System.out.print(numero + " ");
        System.out.println("]");
    }
}
