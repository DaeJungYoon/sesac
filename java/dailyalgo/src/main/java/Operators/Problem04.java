package Operators;

public class Problem04 {
//    두 수의 곱셈
//    문제 설명
//    두 개의 자연수 number1과 number2가 주어질 때, 이 두 수의 곱을 반환하는 solution 함수를 작성하시오.
//    제한 사항
//    number1과 number2는 1 이상 100 이하의 자연수입니다.
    public static void main(String[] args) {
        System.out.println(Solution.solution(1,2));

    }

    class Solution {
        public static int solution(int number1, int number2) {
            int answer = 0;
            answer = number1* number2;
            return answer;

        }
    }
}
