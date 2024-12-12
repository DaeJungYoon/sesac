package loop;

public class Problem20 {
//    범위 내 배수의 합 구하기
//    문제 설명
//    세 자연수 start, end, number가 주어질 때, start부터 end까지(두 수를 포함한 범위)의 수 중에서 number의 배수인 수들의 합을 구하는 solution 함수를 작성하시오.
//    제한 사항
//    start와 end는 10 이상 100 이하의 자연수입니다.
//    start는 end보다 작거나 같은 값으로 주어집니다.
//    number는 2 이상 9 이하의 자연수입니다.
//    start부터 end까지의 자연수 중에서 number의 배수가 존재하지 않는 경우는 입력으로 주어지지 않습니다.
    public static void main(String[] args) {
        System.out.println(Solution.solution(10,20,3));

    }

    class Solution {
        public static int solution(int start, int end, int number) {
            int answer = 0;
            for (int i=start; i<end+1;i++){
                if(i%number==0){
                    answer += i;
                }
            }
            return answer;
        }
    }
}
