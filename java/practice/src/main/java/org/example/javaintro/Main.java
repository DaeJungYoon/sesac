package org.example.javaintro;

import org.example.priv.tmp.DefaultModifier;

public class Main {
    public static void main(String[] args) {

    PrivateModifier pm = new PrivateModifier();
    pm.publicNum = 1000000;
    System.out.println(pm.publicNum);

        System.out.println(pm.getPrivateNum());
        pm.setPrivateNum(100);
        System.out.println(pm.getPrivateNum());
        pm.publicHi();
//        pm.privateHi();
        pm.sayHi();

        DefaultModifier dm = new DefaultModifier();
        System.out.println(dm.publicString);
//        System.out.println(dm.defaultString);
    }


}
