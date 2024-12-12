package conditional;

public class Problem13 {
//    범위 내 숫자 판별하기
//    문제 설명
//    정수 number, 범위의 시작 값 start, 끝 값 end가 주어질 때,
//    number가 해당 범위(start 이상, end 이하) 내에 있는지 판별하는 solution 함수를 작성하시오.
//    제한 사항
//    number, start, end는 -100 이상 100 이하의 정수입니다.
//    start는 end보다 작거나 같습니다.
//    number가 범위 내에 있으면 YES라는 문자열을, 범위 밖에 있으면 NO라는 문자열을 반환합니다.
    public static void main(String[] args) {
        System.out.println(Solution.solution(41,1,10));

    }

    class Solution {
        public static String solution(int number, int start, int end) {
            String answer = "";
            answer = start<=number && number <= end ? "YES":"NO";
            return answer;
        }
    }
}
