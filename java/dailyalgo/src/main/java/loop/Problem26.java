package loop;

public class Problem26 {
//    모든 소수 곱의 총합 구하기
//    문제 설명
//    두 자연수 start와 end가 주어질 때, start부터 end까지(두 수를 포함한 범위)의 수 중에서 소수인 두 수의 모든 곱 조합을 구하여
//    그 합을 반환하는 solution 함수를 작성하시오. 소수란, 1과 자기 자신만을 약수로 가지는 1보다 큰 자연수를 의미합니다.
//    예를 들어 2, 3, 5, 7은 소수이지만 4, 6, 8은 소수가 아닙니다.
//    제한 사항
//    start와 end는 1 이상 100 이하의 자연수입니다.
//    start는 end보다 작거나 같은 값으로 주어집니다.
//    start부터 end까지의 자연수 중에서 소수가 1개 이하로 존재하는 경우에는 0을 반환합니다.
    public static void main(String[] args) {
        System.out.println(Solution.solution(2,5));

    }

    class Solution {

        public static int solution(int start, int end) {
            int answer = 0;

            for (int i = start; i <= end; i++) {
                if (isPrime(i)) {
                    for (int j = i + 1; j <= end; j++) {
                        if (isPrime(j)) {
                            answer += i * j;
                        }
                    }
                }
            }

            return answer;
        }

        static boolean isPrime(int number) {
            if (number <= 1) {
                return false;
            }

            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
