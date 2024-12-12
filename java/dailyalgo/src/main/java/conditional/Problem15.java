package conditional;

public class Problem15 {
//    윤년 판별하기
//    문제 설명
//    윤년이란, 2월 29일이 존재하는 연도를 의미하며 4년에 한 번씩 돌아옵니다.
//    특정 연도 year가 주어질 때, 해당 연도가 윤년인지 판별하는 solution 함수를 작성하시오.
//
//    윤년을 판별하는 방법은 아래와 같습니다.
//    4로 나누어떨어지는 해는 윤년입니다.
//    단, 100으로 나누어떨어지는 해는 윤년이 아닙니다.
//    하지만 400으로 나누어떨어지는 해는 윤년입니다.
//    제한 사항
//    year는 1 이상 4000 이하의 자연수입니다.
//    year가 윤년이면 YES라는 문자열을, 윤년이 아니면 NO라는 문자열을 반환합니다.
    public static void main(String[] args) {
        System.out.println(Solution.solution(2000));

    }

    class Solution {
        public static String solution(int year) {
            String answer = "";
            if (year%100!=0 && year%4==0){
                    answer = "YES";
            }else if(year%400 == 0){
                answer = "YES";
            }else{
                answer="NO";
            }
            return answer;
        }
    }
}
