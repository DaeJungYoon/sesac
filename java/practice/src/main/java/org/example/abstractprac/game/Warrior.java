package org.example.abstractprac.game;

public class Warrior extends Charactor implements Rageable {
    public int range;

    public Warrior(String name) {
        super(name);
        this.level = 1;
        this.health = 120;
        this.maxHealth =120;
    }

    @Override
    public void attack() {
        System.out.println("attack!");
    }

    @Override
    public void levelUp() {
        level +=1;
        maxHealth += 30;
        health +=maxHealth;
        System.out.println("worrior level up");
    }

    @Override
    public void rageMethod() {
        System.out.println("range+10");
        range +=10;
    }
}
