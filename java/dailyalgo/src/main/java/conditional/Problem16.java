package conditional;

public class Problem16 {
//    비만도 계산하기
//    문제 설명
//    BMI는 사람의 비만도를 나타내는 체질량지수로, 몸무게를 키의 제곱으로 나누어 계산할 수 있습니다.
//    몸무게를 의미하는 weight와 키를 의미하는 height가 주어졌을 때, BMI를 계산한 값에 따라 상태를 반환하는 solution 함수를 작성하시오.
//
//    BMI에 따라 상태를 나누는 기준은 아래와 같습니다.
//    18.5 미만 : 저체중
//    18.5 이상 23 미만 : 정상
//    23 이상 25 미만 : 과체중
//    25 이상 : 비만
//    제한 사항
//    weight는 30 이상 100 이하의 실수입니다. (단위 : kg)
//    height는 1.4 이상 2.0 이하의 실수입니다. (단위 : m)
    public static void main(String[] args) {
        System.out.println(Solution.solution(30, 1.4));

    }

    class Solution {
        public static String solution(double weight, double height) {
            String answer = "";
            if(weight/Math.pow(height,2)<18.5){
                answer = "저체중";
            }else if(weight/Math.pow(height,2)<23){
                answer = "정상";
            }else if(weight/Math.pow(height,2)<25){
                answer = "과체중";
            }else{
                answer = "비만";
            }
            return answer;
        }
    }
}
