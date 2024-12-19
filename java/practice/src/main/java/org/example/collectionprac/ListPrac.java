package org.example.collectionprac;

//import org.example.inheritance.Student;

import java.util.ArrayList;

public class ListPrac {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
//        Student student = new Student();
//        data 삽입
        list.add(1);
        list.add(3);

        System.out.println(list); // [1,3]

        list.add(1,100);
        System.out.println(list); // [1,100,3]

        // 접근
        System.out.println(list.get(0)); // 1
        System.out.println(list.getFirst()); // 1

        // 수정
        list.set(1, 1000);
        System.out.println(list); // [1,1000,3]


        // list를 반복을 돈다. "길이"
        System.out.println(list.size()); // 3

//        list.isEmpty();
        if(!list.isEmpty()){
            list.get(0);
        }
        for (int index = 0; index < list.size(); index++) {
            System.out.println(list.get(index));
                // 1
                // 1000
                // 3
        }

        ArrayList<Object> strings = new ArrayList<>();
        strings.add("1");
        System.out.println(strings);
    }
}
