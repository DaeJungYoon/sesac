package org.example.abstractprac.game;

public abstract class Charactor implements GetDamage {
    private String name;
    protected int level;
    protected int health;
    protected int maxHealth;

    public Charactor(String name) {
        this.name = name;
        this.level = 1;
        this.health = 100;
        this.maxHealth =100;
    }
    public abstract void attack();
    public abstract void levelUp();

    @Override
    public void hit() {
    }
}
