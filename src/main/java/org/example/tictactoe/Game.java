package org.example.tictactoe;

import lombok.Getter;

public class Game {
    @Getter
    private Player p1;
    @Getter
    private Player p2;
    @Getter
    private Player nextTurn;

    private String[][] gameState = new String[3][3];
    public Game(String p1Char,String p2Char) {
        p1 = new Player(p1Char);
        p2 = new Player(p2Char);
        //init nextTurn for p1
        nextTurn = p1;
    }
    public String getCharInTheBox(int boxNo){
        int row = (boxNo - 1) / 3;
        int col = (boxNo - 1) % 3;

        if(boxNo < 1 || boxNo > 9) {
            throw new IllegalArgumentException("box no should be between 1 and 9");
        }
        else {
            return gameState[row][col];
        }


    }
int turnsPlayed = 0;
    public void nextAttempt(int boxNo){
        int row = (boxNo - 1) / 3;
        int col = (boxNo - 1) % 3;
        if(boxNo < 1 || boxNo > 9) {
            throw new IllegalArgumentException("box no should be between 1 and 9");
        }
        if(gameState[row][col] != null) {
            throw new IllegalStateException("this box is not empty");
        }
        gameState[row][col] = nextTurn.getCharacter();
        if(nextTurn == p1)nextTurn = p2;
        else nextTurn = p1;
        turnsPlayed++;
    }

   public int returnVictory(){
        Player winner = checkVictory();
        if(winner == p1){
            System.out.println(p1.getCharacter() + "has won the game");
            return 1;
        }
        else if( winner == p2){
            System.out.println(p2.getCharacter() + "has won the game");
            return 1;
        }
        else if(turnsPlayed > 9 && winner == null){
            System.out.println("draw");
            return 1;
        }
        return 0;
    }


    /**
     * checks board state and tells if any winner
     *  p1 and p2 whoever has won or null if no winner yet
     */
    public Player checkVictory(){

        if((gameState[0][0] == "❌" && gameState[0][1] == "❌" && gameState[0][2] == "❌") ||
                (gameState[1][0] == "❌" && gameState[1][1] == "❌" && gameState[1][2] == "❌") ||
                (gameState[2][0] == "❌" && gameState[2][1] == "❌" && gameState[2][2] == "❌") ||
                (gameState[0][0] == "❌" && gameState[1][0] == "❌" && gameState[2][0] == "❌") ||
                (gameState[0][1] == "❌" && gameState[1][1] == "❌" && gameState[2][1] == "❌") ||
                (gameState[0][2] == "❌" && gameState[1][2] == "❌" && gameState[2][2] == "❌") ||
                (gameState[0][0] == "❌" && gameState[1][1] == "❌" && gameState[2][2] == "❌") ||
                (gameState[0][2] == "❌" && gameState[1][1] == "❌" && gameState[2][0] == "❌")){
            return p1;
        }
        else if((gameState[0][0] == "⭕" && gameState[0][1] == "⭕" && gameState[0][2] == "⭕" ) ||
                (gameState[1][0] == "⭕"  && gameState[1][1] == "⭕" && gameState[1][2] == "⭕" ) ||
                (gameState[2][0] == "⭕"  && gameState[2][1] == "⭕" && gameState[2][2] == "⭕" ) ||
                (gameState[0][0] == "⭕"  && gameState[1][0] == "⭕" && gameState[2][0] == "⭕" ) ||
                (gameState[0][1] == "⭕"  && gameState[1][1] == "⭕" && gameState[2][1] == "⭕" ) ||
                (gameState[0][2] == "⭕" && gameState[1][2] == "⭕" && gameState[2][2] == "⭕" ) ||
                (gameState[0][0] == "⭕" && gameState[1][1] == "⭕"  && gameState[2][2] == "⭕" ) ||
                (gameState[0][2] == "⭕" && gameState[1][1] == "⭕" && gameState[2][0] == "⭕" )){
            return p2;
        }
            else
        return null;
    }
}
