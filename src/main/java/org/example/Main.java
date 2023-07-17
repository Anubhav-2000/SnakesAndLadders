package org.example;

import org.example.model.Ladder;
import org.example.model.Player;
import org.example.model.Snake;
import org.example.service.GameService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Snake> snakes= new ArrayList<>();
        List<Ladder> ladders= new ArrayList<>();
        List<Player> players= new ArrayList<>();
        Scanner scanner= new Scanner(System.in);
        int s= scanner.nextInt();
        for(int i=0;i<s;i++){
            snakes.add(new Snake(scanner.nextInt(), scanner.nextInt()));
        }
        int l= scanner.nextInt();
        for(int i=0;i<l;i++){
            ladders.add(new Ladder(scanner.nextInt(), scanner.nextInt()));
        }
        int p= scanner.nextInt();
        for(int i=0;i<p;i++){
            String name= scanner.next();
            players.add(new Player(name));
        }
        System.out.println();
        GameService gameService= new GameService(snakes,ladders,players);
        String player= gameService.simulateGame();
        System.out.println(player +" wins the game");


    }
}