package arrays;

public class Problem45 {
//    배열의 특정 원소 개수 구하기 2
//    문제 설명
//    자연수 원소로 이루어진 배열 numbers가 주어질 때, numbers에 소수가 몇 개 있는지 개수를 반환하는 solution 함수를 작성하시오.
//    (소수란, 1보다 큰 자연수 중 1과 자기 자신만을 약수로 가지는 수를 말한다.)
//    제한 사항
//    numbers의 각 원소는 2 이상 500 이하의 자연수입니다.
//    numbers는 비어있지 않으며, 길이가 100을 넘지 않습니다.
    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[]{5,5,5,5,5,5,5}));
    }
    class Solution {

        public int solution(int[] numbers) {
            int counts = 0;

            for (int number : numbers) {
                boolean isPrime = true;

                for (int i = 2; i <= (int)Math.sqrt(number); i++) {
                    if (number % i == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    counts += 1;
                }
            }

            return counts;
        }
    }
}
