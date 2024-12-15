package loop;

public class Problem25 {
//    각 자릿수의 합 구하기
//    문제 설명
//    주어진 자연수 number의 각 자릿수들의 합을 구하는 solution 함수를 작성하시오.
//    제한 사항
//    number는 1 이상 10^18 이하의 자연수입니다.
    public static void main(String[] args) {
        System.out.println(Solution.solution(5));

    }

    class Solution {
        public static  int solution(int number) {
            int answer = 0;
            for (int i = 1; i <= number; i++) {
                for (int j = 1; j <= i; j++) {
                    if (i % j == 0) {
                        answer += j;
                    }
                }
            }

            return answer;
        }
    }

}
