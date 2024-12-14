package loop;

public class Problem22 {
//    자릿수 구하기
//    문제 설명
//    주어진 자연수 number의 자릿수를 구하는 solution 함수를 작성하시오.
//    제한 사항
//    number는 1 이상 10^18 이하의 자연수입니다.
    public static void main(String[] args) {
        System.out.println(Solution.solution(	12345));

    }

    class Solution {
        public static int solution(long number) {
            int answer = 0;
            while (number>0){
                number/=10;
                answer +=1;

            }
            return answer;
        }
    }
}
