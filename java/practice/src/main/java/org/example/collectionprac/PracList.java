package org.example.collectionprac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class PracList {
    public static void main(String[] args) {
        System.out.println("-------ArrayList-------");
        ArrayList<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        System.out.println("just add = "+strings); // [a, b]
        strings.add(1,"g");
        System.out.println("index add = "+strings); // [a, g, b]

        System.out.println("strings.get(0) = "+strings.get(0)); // a
        System.out.println("strings.get(1) = "+strings.get(1)); // g

        strings.set(1,"t");
        System.out.println("strings.set(1,\"t\") = "+strings); // [a, t, b]

        System.out.println("strings.size() = " + strings.size()); // 3

        System.out.println("strings.isEmpty = "+strings.isEmpty()); // false

        System.out.println("strings.contains(\"a\") = " +strings.contains("a") ); // true
        System.out.println("strings.contains(\"c\") = " +strings.contains("c") ); // false

        System.out.println("strings = "+strings); // [a, t, b]

        strings.remove(1);
        System.out.println("strings.remove(1) -> strings= "+strings); //[a, b]

        System.out.println();
        System.out.println("-------HashMap-------");
        HashMap<String,String> map = new HashMap<>();
        map.put("kyle","2");
        map.put("alex","1");
        map.put("haley","5");
        System.out.println("just put = "+map);//{haley=5, alex=1, kyle=2}
        map.put("kyle","20");
        System.out.println("map.put(\"kyle\",\"20\") -> map = "+map); //{haley=5, alex=1, kyle=20}

        System.out.println("map.get(\"kyle\") = "+map.get("kyle")); // 20
        System.out.println("map.get(\"haley\") = "+map.get("haley")); // 5
        System.out.println("map.get(\"justin\") = "+map.get("justin")); // null

        System.out.println("getOrDefault = "+map.getOrDefault("kyle", "10")); // 20
        System.out.println("getOrDefault = "+map.getOrDefault("justin", "10")); // 10 해당 키가 존재하지 않음

        System.out.println("map.size() = "+map.size()); //3

        System.out.println("map.containsKey(\"kyle\") = "+map.containsKey("kyle")); //true
        System.out.println("map.containsKey(\"justin\") = "+map.containsKey("justin")); //false
        System.out.println("map.containsValue(2)= "+map.containsValue(2)); // true
        System.out.println("map.containsValue(4)= "+map.containsValue(4)); // false

        map.remove("kyle");
        System.out.println(" map.remove(\"kyle\")->map = "+map); //{haley=5, alex=1}
        for(String key : map.keySet()){
            System.out.println(key+ " : " +map.get(key));
            // haley : 5
            // alex : 1
        }

        System.out.println();
        System.out.println("-------HashSet-------");
        HashSet<String> set = new HashSet<>();

        System.out.println();
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(30);
        nums.add(20);
        nums.add(10);
        System.out.println(nums);
        int total =0 ;
        int avg = 0;
        for(int i = 0; i<nums.size(); i++){
            total += nums.get(i);
        }
            avg = total/nums.size();
            System.out.println(total);
            System.out.println(avg);

    }
}
