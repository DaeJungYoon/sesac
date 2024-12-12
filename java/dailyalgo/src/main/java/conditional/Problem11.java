package conditional;

public class Problem11 {
//    짝홀 판별하기
//    문제 설명
//    정수 number가 주어질 때, 그 수가 짝수인지 홀수인지 판별하는 solution 함수를 작성하시오.
//    제한 사항
//    number는 1 이상 100 이하의 자연수입니다.
//    number가 짝수라면 짝수라는 문자열을, 홀수라면 홀수라는 문자열을 반환합니다.
    public static void main(String[] args) {
        System.out.println(Solution.solution(2));

    }

    class Solution {
        public static String solution(int number) {
            String answer = "";
            answer = number % 2 == 0 ? "짝수":"홀수";
            return answer;
        }
    }
}
