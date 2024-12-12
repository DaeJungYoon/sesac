package loop;

public class Problem18 {
//    범위 내 총합 구하기
//    문제 설명
//    두 정수 start와 end가 주어질 때, start부터 end까지(두 수를 포함한 범위)의 총합을 구하는 solution 함수를 작성하시오.
//    제한 사항
//    start와 end는 -100 이상 100 이하의 정수입니다.
//    start는 end보다 작거나 같은 값으로 주어집니다.
    public static void main(String[] args) {
        System.out.println(Solution.solution(1,10));

    }

    class Solution {
        public static int solution(int start, int end) {
            int answer = 0;
            for(int i = start; i <end+1; i++){
                answer += i;
            }
            return answer;
        }
    }
}
