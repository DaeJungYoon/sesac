package arrays;

public class Problem48 {
//    배열 원소의 최대값 찾기
//    문제 설명
//    정수 원소로 이루어진 배열 numbers가 주어질 때, numbers의 원소 중 가장 큰 값을 반환하는 solution 함수를 작성하시오.
//    제한 사항
//    numbers의 각 원소는 절댓값이 500 이하인 정수입니다.
//    numbers는 비어있지 않으며, 길이가 100을 넘지 않습니다.
    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[]{1, 2, 3, 4}));
    }
    class Solution {
        public static int solution(int[] numbers) {
            int answer = 0;

            for (int number : numbers) {
                answer += number;
            }

            return answer;
        }
    }
}
