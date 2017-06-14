package io;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class InputAsker {
    private final Scanner scanner;
    private final PrintStream out;

    public InputAsker(InputStream in, PrintStream out) {
        this.scanner = new Scanner(in);
        this.out = out;
    }

    public Integer askForInteger(String message) {
        out.println(message);
        return scanner.nextInt();
    }

    public Character askForCharacter(String message) {
        out.println(message);
        return scanner.next().charAt(0);
    }
}
