package Operators;

public class Problem08 {
//    거듭제곱
//    문제 설명
//    자연수 number와 exponent가 주어질 때, number의 exponent제곱을 반환하는 solution 함수를 작성하시오.
//    제한 사항
//    number와 exponent는 1 이상 9 이하의 자연수입니다.
    public static void main(String[] args) {
        System.out.println(Solution.solution(6,2));

    }

    class Solution {
        public static int solution(int number, int exponent) {
            int answer = 0;
            answer = (int) Math.pow(number, exponent);
            return answer;
        }
    }
}
