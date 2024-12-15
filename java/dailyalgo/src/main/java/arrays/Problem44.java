package arrays;

public class Problem44 {
//    배열의 특정 원소 개수 구하기 1
//    문제 설명
//    자연수 n과 자연수 원소로 이루어진 배열 numbers가 주어질 때, numbers에 n이 몇 개 있는지 개수를 반환하는 solution 함수를 작성하시오.
//    제한 사항
//    n과 numbers의 각 원소는 10 이하의 자연수입니다.
//    numbers는 비어있지 않으며, 길이가 100을 넘지 않습니다.
    public static void main(String[] args) {
        System.out.println(Solution.solution(5,new int[]{5,5,5,5,5,5,5}));
    }
    public class Solution {
        public static int solution(int n, int[] numbers) {
            int answer = 0;

            for (int number : numbers) {
                if (n == number) {
                    answer += 1;
                }
            }
            return answer;
        }
    }
}
