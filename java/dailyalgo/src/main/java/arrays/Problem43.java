package arrays;

public class Problem43 {
//    배열의 길이 구하기
//    문제 설명
//    정수 원소로 이루어진 배열 numbers가 주어질 때, numbers의 길이(= 총 원소의 개수)를 반환하는 solution 함수를 작성하시오.
//    제한 사항
//    numbers의 각 원소는 0 이상 500 이하의 정수입니다.
//    numbers는 비어있지 않으며, 길이가 100을 넘지 않습니다.
    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[]{0, 1, 2, 3, 4}));
    }
    class Solution {
        public static int solution(int[] numbers) {
            return numbers.length;
        }
    }
}
