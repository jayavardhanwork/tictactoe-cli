package org.example.tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    /*
    constuct game object with 2 players
    for every turn print whose turn it is and state of game
    Read input from 1 to 9 as the box to be marked by next player
    validate input and mark the box
        if input invalid make player enter box no again
    Repeat steps 2 -4 until either:
        checkVictory function shows any player has won
        or all boxes have been marked
     */

        Game g = new Game("❌","⭕");
        System.out.println(g.getNextTurn().getCharacter()+" enter the box number");
        Scanner sc = new Scanner(System.in);

        while(g.turnsPlayed < 9){
            try{
                g.nextAttempt(sc.nextInt());
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        System.out.print(g.getCharInTheBox((i*3)+j+1));
                    }
                    System.out.println();
                }
                if(g.returnVictory() == 1){
                    break;
                }
                System.out.println(g.getNextTurn().getCharacter() + " enter box number");
            }
            catch (Exception e){
                System.out.println(e);
            }


        }
    }
}
