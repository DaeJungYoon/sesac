package org.example.exceptionprac;

public class Main {
    public static void main(String[] args) {

//       todo: error 처리
        try {
        System.out.println(0/0);

        }
        catch(ArithmeticException e) {
            System.out.println(e.getMessage());
            System.out.println("error!");
        }
        try{
            // 문제상황이 발생했다고 가정
            // if(스페셜 어택이 불가능하면)
            if(true){
                throw new RuntimeException("error message");
            }
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("runtime error");
        }
    try{
        func();
    }catch(RuntimeException e){
        System.out.println("error in func");
    }
    }

    public static void func(){
        System.out.println("func run");
        throw new RuntimeException("func error");
    }
}
