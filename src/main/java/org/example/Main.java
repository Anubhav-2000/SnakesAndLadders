package org.example;

import org.example.model.*;

import java.sql.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int snakeCount = scanner.nextInt();
        Map<Integer,Integer> snakes= new HashMap<>();
        Map<Integer,Integer> ladders= new HashMap<>();
        for(int i=0;i<snakeCount;i++){
            int head =scanner.nextInt();
            int tail = scanner.nextInt();
            snakes.put(head,tail);
        }
        int ladderCount = scanner.nextInt();
        for(int i=0;i<ladderCount;i++){
            int head =scanner.nextInt();
            int tail = scanner.nextInt();
            ladders.put(head,tail);
        }
        int numPlayers = scanner.nextInt();
        scanner.nextLine();
        List<Player> players = new ArrayList<>(numPlayers);
        for(int i=0;i<numPlayers;i++){
            String name = scanner.nextLine();
            Player player = new Player(name);
            players.add(player);
        }
        System.out.println();
        Dice singleDice = new SingleDice();
        Dice doubleDice = new DoubleDice();
        Board board = new Board(200,doubleDice,0,ladders,snakes,players);
        while(!board.hasGameEnded()){
            board.simulateTurn();
        }
        System.out.println(board.getWinners());

    }
}