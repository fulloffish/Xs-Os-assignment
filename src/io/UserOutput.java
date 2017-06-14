package io;

import game.Board;
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
    }