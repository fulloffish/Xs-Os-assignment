package io;

import game.Board;
import game.Player;
import game.Seed;

public class UserOutput {

    public void printWhoStarts(Player player) {
        System.out.println("Player " + player + " will be the first player this round!");
    }

    public void printCurrentPlayer(Player player, Integer rows, Integer cols) {
        System.out.println("Player '" + player + "', enter your move (row[1-" + rows.toString() +"], column[1-" + cols.toString() + "]) ");
    }

    public void showBoard(Board board) {
        for(Integer rowIndex = 0; rowIndex < board.ROWS; rowIndex++){
//            System.out.println("Row: " + rowIndex.toString());
            for(Integer columnIndex = 0; columnIndex < board.COLS; columnIndex++) {
//                System.out.println("Column: " + columnIndex.toString());
                if (board.getCell(rowIndex, columnIndex).getContent().equals(Seed.EMPTY)) {
                    System.out.printf("|   ");
                } else if (board.getCell(rowIndex, columnIndex).getContent().equals(Seed.CROSS)) {
                    System.out.printf("| X ");
                } else if (board.getCell(rowIndex, columnIndex).getContent().equals(Seed.NOUGHT)) {
                    System.out.printf("| O ");
                }
                if (columnIndex == board.COLS - 1) {
                    System.out.printf("|\n");
                }
            }
            if (rowIndex != board.ROWS - 1) {

                System.out.println(this.getDashes(board));
            }
        }
    }

    private String getDashes(Board board) {
        String dashes = "";
        for(int i = 0; i < 4*board.COLS + 1; i++) {
            dashes += "-";
        }
        dashes += "\n";
        return dashes;
    }

    public void printWhoWon(Player player) {
        if (player == player.X) {
            System.out.println("Player X wins!");
        } else {
            System.out.println("Player O wins!");
        }
    }

    public void printThereIsADraw() {
        System.out.println("End of game. Draw!");
    }
}
