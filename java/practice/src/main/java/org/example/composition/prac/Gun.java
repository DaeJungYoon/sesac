package org.example.composition.prac;

public class Gun extends Weapon implements SkillAttackAble {

    public Gun(int attackPower, Gun gun, Sword sword) {
        super(attackPower, gun, sword);
    }

    @Override
    public void skill() {
        System.out.println("bang");
    }

//    public void bang(){
//        System.out.println("bang");
//    }
}
