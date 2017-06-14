package io;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by krzysiek on 6/14/17.
 */
public class UserInput {
    Scanner scanner = new Scanner(System.in);


    public Integer getCoordinate(Integer maximum) {
        // print
        Integer coordinate = scanner.nextInt();
        while (coordinate < 1 && coordinate > maximum) {
            coordinate = scanner.nextInt();
        }
        scanner.close();
        return coordinate;
    }

    public Character getInputYesOrNo() {
        Character input = scanner.next().charAt(0);
        Character response = Character.toUpperCase(input);
        scanner.close();
        return response;
    }

}
