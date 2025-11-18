package ed.u2.sorting;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SortingDemo {

    public static void main(String[] args) {

        int[][] datasets = {
                {8,3,6,3,9},   // A
                {5,4,3,2,1},   // B
                {1,2,3,4,5},   // C
                {2,2,2,2},     // D
                {9,1,8,2}      // E
        };

        String[] Letras = {"A","B","C","D","E"};

        // Crear carpetas
        createDir("traces/insertion");
        createDir("traces/selection");
        createDir("traces/bubble");

        for (int i = 0; i < datasets.length; i++) {

            int[] base = datasets[i];
            String Letra = Letras[i];

            // Insertion
            runAndSaveBoth(() -> InsertionSort.sort(SortingUtils.copy(base), true),
                    "traces/insertion/" + Letra + ".txt"
            );

            // Selection
            runAndSaveBoth(() -> SelectionSort.sort(SortingUtils.copy(base), true),
                    "traces/selection/" + Letra + ".txt"
            );

            // Bubble
            runAndSaveBoth(() -> BurbbleSort.sort(SortingUtils.copy(base), true),
                    "traces/bubble/" + Letra + ".txt"
            );
        }
    }

    private static void createDir(String path) {
        try {
            Path p = Paths.get(path);
            if (!Files.exists(p)) {
                Files.createDirectories(p);
            }
        } catch (IOException e) {
            System.err.println("Error creando carpeta: " + path);
        }
    }

    private static void runAndSaveBoth(Runnable task, String filename) {
        PrintStream original = System.out;

        try (FileOutputStream fos = new FileOutputStream(filename)) {

            // Doble salida: archivo + consola
            PrintStream dual = new DualPrintStream(original, new PrintStream(fos));

            System.setOut(dual);  // redirigir a dual
            task.run();

        } catch (IOException e) {
            original.println("Error creando archivo: " + filename);
        } finally {
            System.setOut(original); // restaurar consola
        }
    }
}
