package io;

import game.Player;

/**
 * Created by krzysiek on 6/14/17.
 */
public class UserOutput {

    public void printWhoStarts(Player player) {
        System.out.println("Player " + player + "will be the first player this round!");
    }

    public void printCurrentPlayer(Player player, Integer rows, Integer cols) {
        System.out.println("Player " + player + "plays");
        System.out.println("Enter your move (row[1-" + rows.toString() +"], column[1-" + cols.toString() + "]: ");
    }

    public void displayBoard() {
        int[] a = new int[9];
        a[0] = a[5] = a[6] = 10;
        a[3] = a[7] = 100;
        a[1] = a[2] = a[4] = a[8] = 0;
        for (int i=0; i<9; i+=3) {
            System.out.println("+---+---+---+");
            for (int j=i; j<i+3; ++j) {
                System.out.println("| %s ", a[j] ==10 ? "0" : a[j] ==100 ? "X" : " ");
            }
        }
    }
}
