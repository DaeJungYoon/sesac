package org.example.abstractprac.game;

public class Mage extends Charactor implements Manable{
    public int mana;

    public Mage(String name) {
        super(name);
        this.health = 70;
        this.maxHealth =70;
    }

    @Override
    public void attack() {
        System.out.println("mage attack");

    }

    @Override
    public void levelUp() {

        level += 1;
        maxHealth +=15;
        health +=15;
        System.out.println("mage level up");
    }

    @Override
    public int manaMethod() {
        System.out.println("mana +10");
        return mana +=10;
    }
}
