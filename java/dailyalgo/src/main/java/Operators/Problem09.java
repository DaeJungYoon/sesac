package Operators;

public class Problem09 {
//    제곱근 구하기
//    문제 설명
//    자연수 number가 주어질 때, number의 제곱근의 정수 부분만 반환하는 solution 함수를 작성하시오.
//    제한사항
//    number는 1 이상 100 이하의 자연수입니다.
    public static void main(String[] args) {
        System.out.println(Solution.solution(4));

    }

    class Solution {
        public static int solution(int number) {
            int answer = 0;
            answer = (int) Math.sqrt(number);
            return answer;
        }
    }
}
