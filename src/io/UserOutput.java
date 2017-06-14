package io;

import game.Board;
import game.Player;

/**
 * Created by krzysiek on 6/14/17.
 */
public class UserOutput {
    protected char[] board;

    public void printWhoStarts(Player player) {
        System.out.println("Player " + player + "will be the first player this round!");
    }

    public void printCurrentPlayer(Player player, Integer rows, Integer cols) {
        System.out.println("Player " + player + "plays");
        System.out.println("Enter your move (row[1-" + rows.toString() +"], column[1-" + cols.toString() + "]: ");
    }


    public static char[] setBoard() {
        char[] board = new char[9];
        for (int i = 0; i < board.length; i++) {
            board[i] = ' ';
        }
        return board;
    }

    public void showBoard() {
        this.board = setBoard();
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println();
                System.out.println("------------");
            }
            System.out.print(board[i] + " |");
        }
        System.out.println();
    }
}
