package Operators;

public class Problem10 {
//    두 수의 크기 비교하기
//    문제 설명
//    두 개의 자연수 number1과 number2가 주어질 때, 더 큰 수를 반환하는 solution 함수를 작성하시오.
//    제한 사항
//    number1과 number2는 1 이상 100 이하의 서로 다른 자연수입니다.
    public static void main(String[] args) {
        System.out.println(Solution.solution(2, 4));

    }

    class Solution {
        public static int solution(int number1, int number2) {
            int answer = 0;
            answer = number1 > number2 ? number1: number2;
            return answer;
        }
    }
}
