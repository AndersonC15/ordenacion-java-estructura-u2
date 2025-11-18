package ed.u2.sorting;

import java.util.Arrays;

public final class SortingUtils {

    public static String toString(int[] a) {
        return Arrays.toString(a);
    }

    public static int[] copy(int[] a) {
        return Arrays.copyOf(a, a.length);
    }
}
