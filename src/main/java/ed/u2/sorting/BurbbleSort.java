package ed.u2.sorting;

public final class BurbbleSort {

    public static void sort(int[] a) {
        sort(a, false);
    }

    public static void sort(int[] a, boolean trace) {
        int n = a.length;
        int totalSwaps = 0;

        if (trace) {
            System.out.println("=== BUBBLE SORT ===");
        }

        for (int pass = 0; pass < n - 1; pass++) {
            boolean swapped = false;
            int swapsThisPass = 0;

            for (int j = 0; j < n - 1 - pass; j++) {
                if (a[j] > a[j + 1]) {
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

            if (trace) {
                System.out.println("pasada " + pass + " | swaps = " + swapsThisPass);
            }

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
