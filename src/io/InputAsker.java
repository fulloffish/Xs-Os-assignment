package io;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class IntegerAsker {
    private final Scanner scanner;
    private final PrintStream out;

    public IntegerAsker(InputStream in, PrintStream out) {
        this.scanner = new Scanner(in);
        this.out = out;
    }

    public Integer ask(String message) {
        out.println(message);
        return scanner.nextInt();
    }
}
