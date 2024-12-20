package org.example.collectionprac;

import java.util.ArrayList;
import java.util.HashMap;

public class Student {
     public int age;
     public String name;
     public Subject subject;

     public Student(int age, String name) {
          this.age = age;
          this.name = name;
     }
//     public static void main(String[] args) {
//     ArrayList<String> names = new ArrayList<>();
//     HashMap<String, Integer>ages = new HashMap<>();
//     HashMap<String, Integer>subjs = new HashMap<>();
//     HashMap<String, Integer>avgs = new HashMap<>();
//
//     names.add("kyle");
//     names.add("haley");
//     names.add("justin");
//     System.out.println(names);
//     ages.put("Kyle",17);
//     ages.put("haley",19);
//     ages.put("justin",16);
//     System.out.println(ages);
//     subjs.put("aerodynamics" , 90);
//     subjs.put("hydrodynamics" , 80);
//     subjs.put("mechanics of materials",60);
//     System.out.println(subjs);
//     int total = 0;
//     int avg = 0;
//     for(String score : subjs.keySet()){
//          total += subjs.get(score);
//     }
//     avg = total/subjs.size();
//
//
//
//
//
//     }


}
