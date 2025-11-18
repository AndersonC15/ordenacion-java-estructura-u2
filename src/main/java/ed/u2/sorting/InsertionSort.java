package ed.u2.sorting;

public final class InsertionSort {

    // Contador de movimientos realizados durante el ordenamiento
    private static int contadorMovimientos;

    public static int getContadorMovimientos() {
        return contadorMovimientos;
    }

    public static void sort(int[] arreglo) {
        sort(arreglo, false);
    }

    public static void sort(int[] arreglo, boolean trazar) {

        contadorMovimientos = 0;

        if (arreglo == null || arreglo.length <= 1) return;

        for (int indiceActual = 1; indiceActual < arreglo.length; indiceActual++) {

            int valorAInsertar = arreglo[indiceActual];
            int indiceComparacion = indiceActual - 1;

            if (trazar) {
                System.out.println("---- Iteración indiceActual =" + indiceActual + " ----");
                System.out.println("Valor a insertar: " + valorAInsertar);
            }

            // Mover elementos mayores hacia la derecha
            while (indiceComparacion >= 0 && arreglo[indiceComparacion] > valorAInsertar) {

                arreglo[indiceComparacion + 1] = arreglo[indiceComparacion];
                contadorMovimientos++;

                if (trazar) {
                    System.out.println("Mover arreglo[" + indiceComparacion + "] -> arreglo[" + (indiceComparacion + 1) + "]");
                    imprimirArreglo(arreglo);
                }
                indiceComparacion--;
            }

            // Insertar el valor en la posición correcta
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
