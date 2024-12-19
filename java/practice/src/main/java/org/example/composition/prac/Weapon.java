package org.example.composition.prac;

public class Weapon {
    public int attackPower;
    public int durability;
    public Gun gun;
    public Sword sword;

    public Weapon(int attackPower, Gun gun, Sword sword) {
        this.attackPower = attackPower;
        this.durability = 100;
        this.gun = gun;
        this.sword = sword;
    }
}
