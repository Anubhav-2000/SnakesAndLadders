package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Board {
    private List<Player> players;
    Map<Integer,Integer> snakes;
    Map<Integer,Integer> ladders;
    int turnIdx;
    List<Player> winners = new ArrayList<>();
    Dice dice;
    int boardSize;

    public Board(int boardSize, Dice dice, int turnIdx, Map<Integer, Integer> ladders, Map<Integer, Integer> snakes, List<Player> players) {
        this.boardSize = boardSize;
        this.dice = dice;
        this.turnIdx = turnIdx;
        this.ladders = ladders;
        this.snakes = snakes;
        this.players = players;
    }

    public void simulateTurn(){
        Player currPlayer = players.get(turnIdx);
        int diceRoll = dice.getDiceRoll();

        int initialPos= currPlayer.getPosition();
        if(initialPos + diceRoll > boardSize) {
            System.out.println(currPlayer.getName()+" rolled a "+diceRoll+" and can't move");
            updateTurnIdx();
            return;
        }
        int finalPos= getFinalPos(initialPos+diceRoll);
        currPlayer.setPosition(finalPos);
        if(finalPos ==boardSize) {
            winners.add(currPlayer);
            players.remove(turnIdx);
            //System.out.println(currPlayer.getName()+" rolled a "+diceRoll+" and moved from "+initialPos+" to "+ finalPos);
        }
        System.out.println(currPlayer.getName()+" rolled a "+diceRoll+" and moved from "+initialPos+" to "+ finalPos);
        updateTurnIdx();

    }
    private int getFinalPos(int pos){
        if(!snakes.containsKey(pos) || !ladders.containsKey(pos)){
            return pos;
        }
        if(snakes.containsKey(pos)) return getFinalPos(snakes.get(pos));
        else if(ladders.containsKey(pos)) return getFinalPos(ladders.get(pos));

        return pos;
    }
    public boolean hasGameEnded(){
        return players.size()==1;
    }

    public String getWinners() {
        StringBuilder result = new StringBuilder();
        for(int i=0;i<winners.size();i++){
            result.append((i+1)+"position is "+ winners.get(i).getName() +"\n");
        }
        result.append("Loser is "+players.get(0).getName());
        return result.toString();
    }
    private void updateTurnIdx(){
        if(turnIdx >= players.size()) turnIdx = 0;
        else {
            turnIdx++;
            if(turnIdx >= players.size()) turnIdx = 0;
        }


    }
}
