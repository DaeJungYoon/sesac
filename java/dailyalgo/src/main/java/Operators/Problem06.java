package Operators;

public class Problem06 {
//    몫 구하기
//    문제 설명
//    두 개의 자연수 number1과 number2가 주어질 때, number1을 number2로 나눈 몫을 반환하는 solution 함수를 작성하시오.
//    제한 사항
//    number1과 number2는 1 이상 100 이하의 자연수입니다.
    public static void main(String[] args) {
        System.out.println(Solution.solution(6,2));

    }

    class Solution {
        public static int solution(int number1, int number2) {
            int answer = 0;
            answer = number1/ number2;
            return answer;

        }
    }
}
