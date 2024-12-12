package conditional;

public class Problem12 {
//    부호 판별하기
//    문제 설명
//    정수 number가 주어질 때, 해당 정수의 부호를 판별하는 solution 함수를 작성하시오.
//    제한 사항
//    number는 -100 이상 100 이하의 정수입니다.
//    number가 양수이면 POSITIVE라는 문자열을, 음수이면 NEGATIVE라는 문자열을, 0이면 ZERO라는 문자열을 반환합니다.
    public static void main(String[] args) {
        System.out.println(Solution.solution(0));

    }

    class Solution {
        public static String solution(int number) {
            String answer = "";
            if(number>0){
                answer = "POSITIVE";
            }else if(number<0){
                answer = "NEGATIVE";
            }else{
                answer = "ZERO";
            }
            return answer;
        }
    }
}
