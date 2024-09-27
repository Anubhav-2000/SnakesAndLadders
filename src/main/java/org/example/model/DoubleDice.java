package org.example.model;

import java.util.concurrent.ThreadLocalRandom;

public class DoubleDice implements Dice{
    int min = 2;
    int max = 12;
    @Override
    public int getDiceRoll() {
        return ThreadLocalRandom.current().nextInt(min , max + 1);
    }
}
