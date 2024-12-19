package org.example.collectionprac;

import java.util.HashMap;
import java.util.Set;

public class MapPrac {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        // ja
        //map[korean] = 100;
        map.put("korean",100);
        map.put("english",10);
        System.out.println(map); //{english=10, korean=100}

        map.put("korean", 30);
        System.out.println(map); //{english=10, korean=30}

        System.out.println(map.get("korean"));//30
        System.out.println(map.get("math")); //null
        System.out.println(map.getOrDefault("math",0)); //0
        System.out.println(map.getOrDefault("korean",0)); //30

        // 크기
        System.out.println(map.size()); //2

        Set<String> keys = map.keySet();

        for(String key : keys){
            Integer value = map.get(key);
            System.out.println(key + value);
            //english10
            //korean30
        }



    }
}
