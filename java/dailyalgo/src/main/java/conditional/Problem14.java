package conditional;

public class Problem14 {
//    성적 판별하기
//    문제 설명
//    점수 score가 주어질 때, 점수에 따라 성적을 판별하여 A, B, C, D, F 중 하나를 반환하는 solution 함수를 작성하시오.
//    score에 따른 성적 기준은 아래와 같습니다.
//    90점 이상: A
//    80점 이상 90점 미만: B
//    70점 이상 80점 미만: C
//    60점 이상 70점 미만: D
//    60점 미만: F
//    제한 사항
//    score는 0 이상 100 이하의 정수입니다.
    public static void main(String[] args) {
        System.out.println(Solution.solution(40));

    }

    class Solution {
        public static String solution(int score) {
            String answer = "";
            if (score>=90){
                answer = "A";
            }else if (score >= 80){
                answer = "B";
            }else if (score >=70){
                answer = "C";
            }else if(score >=60){
                answer = "D";
            }else{
                answer="F";
            }
            return answer;
        }
    }
}
