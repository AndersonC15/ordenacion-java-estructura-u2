/**
 * Clase DualPrintStream:
 * Sirve para duplicar la salida del programa.
 * Todo lo que se imprima se enviará a la consola y también a un archivo .txt.
 * Se usa en SortingDemo para guardar las trazas.
 */

package ed.u2.sorting;

import java.io.PrintStream;

public class DualPrintStream extends PrintStream {

    private final PrintStream fileOut;     // Salida al archivo
    private final PrintStream consoleOut;  // Salida a la consola

    public DualPrintStream(PrintStream consoleOut, PrintStream fileOut) {
        super(fileOut);
        this.consoleOut = consoleOut;
        this.fileOut = fileOut;
    }

    // Duplicar println
    @Override
    public void println(String x) {
        consoleOut.println(x);
        fileOut.println(x);
    }

    // Duplicar print
    @Override
    public void print(String x) {
        consoleOut.print(x);
        fileOut.print(x);
    }
}
