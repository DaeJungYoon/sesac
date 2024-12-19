package org.example.composition.prac;

public class Sword extends Weapon implements SkillAttackAble {

    public Sword(int attackPower, Gun gun, Sword sword) {
        super(attackPower, gun, sword);
    }

    @Override
    public void skill() {
        System.out.println("slash");
    }

//    public void slash(){
//        System.out.println("slash");
//    }
}
