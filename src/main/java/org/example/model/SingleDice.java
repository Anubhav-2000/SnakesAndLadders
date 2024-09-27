package org.example.model;

import java.util.concurrent.ThreadLocalRandom;

public class SingleDice implements Dice{
    int min = 1;
    int max = 6;
    @Override
    public int getDiceRoll() {
        return ThreadLocalRandom.current().nextInt(min , max + 1);
    }
}
