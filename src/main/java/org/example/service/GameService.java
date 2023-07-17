package org.example.service;

import org.example.model.Ladder;
import org.example.model.Player;
import org.example.model.Snake;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GameService {
    List<Snake> snakes= new ArrayList<>();
    List<Ladder> ladders= new ArrayList<>();
    List<Player> players= new ArrayList<>();

    public GameService(List<Snake> snakes, List<Ladder> ladders, List<Player> players) {
        this.snakes = snakes;
        this.ladders = ladders;
        this.players = players;
    }
    public String simulateGame(){
        while(true){
            for(int i=0;i<players.size();i++) {

                Player player= players.get(i);
                int diceRoll= ThreadLocalRandom.current().nextInt(1,7);
                int newPos=  diceRoll +player.getPosition();

                if(newPos >100 ) {
                    System.out.println(player.getName() + " rolled a "+diceRoll+" and moved from "+ player.getPosition()+" to "+ player.getPosition());
                    continue;
                }
                int ladderPos= checkIfLadder(newPos);
                int snakePos= checkIfSnake(newPos);

                if(ladderPos!=-1) newPos=ladderPos;
                else if(snakePos!=-1) newPos=snakePos;

                if(newPos==100){
                    System.out.println(player.getName() + " rolled a "+diceRoll+" and moved from "+ player.getPosition()+" to "+ newPos);
                    player.setPosition(newPos);
                    return player.getName();
                }
                System.out.println(player.getName() + " rolled a "+diceRoll+" and moved from "+ player.getPosition()+" to "+ newPos);
                player.setPosition(newPos);

            }
        }
    }
    public int checkIfSnake(int pos){
        for(Snake snake : snakes){
            if(snake.getHead()==pos) return snake.getTail();
        }
        return -1;
    }
    public int checkIfLadder(int pos){
        for(Ladder ladder : ladders){
            if(ladder.getHead()==pos) return ladder.getTail();
        }
        return -1;
    }
}
