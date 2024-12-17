package org.example.rpg;

public class Main {
    public static void main(String[] args) {
        Character basic = new Character("basic");
        basic.attack();
        basic.levelUp();

        System.out.println("worrior");
        Worrior worrior = new Worrior("Worrior");
        System.out.println(worrior.health);
        worrior.attack();
        worrior.rageUp();
        worrior.attack();
    }
}
