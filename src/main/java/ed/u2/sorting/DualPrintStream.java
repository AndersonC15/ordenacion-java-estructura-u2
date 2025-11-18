package ed.u2.sorting;

import java.io.PrintStream;

public class DualPrintStream extends PrintStream {

    private final PrintStream fileOut;
    private final PrintStream consoleOut;

    public DualPrintStream(PrintStream consoleOut, PrintStream fileOut) {
        super(fileOut);
        this.consoleOut = consoleOut;
        this.fileOut = fileOut;
    }

    @Override
    public void println(String x) {
        consoleOut.println(x);
        fileOut.println(x);
    }

    @Override
    public void print(String x) {
        consoleOut.print(x);
        fileOut.print(x);
    }
}
