package loop;

public class Problem21 {
//    범위 내 소수의 개수 구하기
//    문제 설명
//    두 자연수 start와 end가 주어질 때, start부터 end까지(두 수를 포함한 범위)의 수 중에서 소수인 수들의 개수를 구하는 solution 함수를 작성하시오.
//    소수란, 1과 자기 자신만을 약수로 가지는 1보다 큰 자연수를 의미합니다. 예를 들어 2, 3, 5, 7은 소수이지만 4, 6, 8은 소수가 아닙니다.
//    제한 사항
//    start와 end는 1 이상 100 이하의 자연수입니다.
//    start는 end보다 작거나 같은 값으로 주어집니다.
    public static void main(String[] args) {
        System.out.println(Solution.solution(10,20));

    }

    class Solution {
        public static int solution(int start, int end) {
            int answer = 0;

          for(int i = start; i<=end;i++){
              if (isPrime(i)){
                  /*isPrime 함수에 start부터 end까지의 범위의 int를 넣어어 인자로 출력하면
                  * isPrime이 true이면 실행
                  * */
                  answer++;
//                  answer에 1씩 추가
              }
          }
            return answer;
        }
      static boolean isPrime(int i) {
            if(i<=1){
                return false;
//               매개변수로 받은 i가 1보다 작거나 같으면 false 반환
            }
            for(int j=2;j<=Math.sqrt(i);j++){
                if(i%j==0){
                    return false;
//                j가 2부터 받은 매개변수 i의 제곱근까지 1씩 증가하는데
//                    i에서 j를 나눠 나머지가 나오지 않으면
//                    false 를 반환
                }
            }
            return true;
//            기본적으로 true를 반환
        }
    }
}
