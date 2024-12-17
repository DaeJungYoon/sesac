package org.example.rpg;

public class Character {
    private String name;
    private int level;
    protected int health;
    protected int maxHealth;

    public Character(String name) {
        this.name = name;
        this.level = 1;
        this.health = 100;
        this.maxHealth = 100;
    }

    public void attack(){
        System.out.println("attack");
    }
    public void levelUp(){
        level += 1;
        System.out.println("level = "+level);
    }
}
