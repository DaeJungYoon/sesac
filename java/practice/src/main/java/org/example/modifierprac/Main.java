package org.example.modifierprac;

import org.example.modifierprac.Person;


public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("DENY",123,123.33);
//        p1.run();

//        p1.getName("nuguri");
//        p1.walk();
//        p1.study();
//        p1.showName();
//        System.out.println(showHeight());
//        p1.showStudy();


        BankAccount2 myAccount = new BankAccount2("23");
        myAccount.deposit(1000000);
        myAccount.getBalance("abc123");
        myAccount.withdraw(10000,"abc123");
        myAccount.getBalance("abc123");

        myAccount.getBalance("ghasdg");

        String myPassword = "ashgfghn";
        if(BankAccount2.initialvalidation(myPassword)){
            new BankAccount2(myPassword);
        }else {
            System.out.println("fail..");

        }


    }

}
