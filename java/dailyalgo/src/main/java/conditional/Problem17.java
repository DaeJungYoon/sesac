package conditional;

import java.util.Objects;

public class Problem17 {
//    쇼핑몰 가격 계산하기
//    문제 설명
//    쇼핑몰에서 사용자의 총 구매 금액을 기준으로 아래 할인 기준에 따라 최종 가격을 반환하는 solution 함수를 작성하시오.
//
//    기본 할인
//    100,000원 이상일 경우, 5% 할인
//    300,000원 이상일 경우, 10% 할인
//    500,000원 이상일 경우, 15% 할인
//
//    회원 등급별 추가 할인
//    실버: 추가 3% 할인
//    골드: 추가 5% 할인
//    플래티넘: 추가 10% 할인
//
//    결제 방식별 추가 할인
//    신용카드: 추가 할인 없음
//    현금: 추가 2% 할인
//
//    특별 프로모션
//    할인 적용 전의 총 구매 금액이 500,000원 이상인 플래티넘 회원이 현금 결제를 하는 경우 50,000원 추가 할인
//    할인은 번호 순서에 따라 단계적으로 적용됩니다. 추가 할인은 이전 할인 단계의 결과 금액을 기준으로 적용됩니다.
//    제한 사항
//    totalPrice는 총 구매 금액을 의미하며 10,000 이상 1,000,000 이하의 자연수입니다. 10,000의 배수 형태로 주어집니다.
//    membership은 회원 등급을 의미하며 "실버", "골드", "플래티넘" 중 하나입니다.
//    paymentMethod는 결제 방식을 의미하며 "신용카드", "현금" 중 하나입니다.
//    최종 가격은 소수 부분을 제거하고 정수 부분만 반환합니다.
//
//    할인 적용 순서:
//    기본 할인: 550,000원이므로 15% 할인, 550000 * 0.85 = 467500
//    회원 등급 할인: 플래티넘 회원이므로 10% 추가 할인, 467500 * 0.90 = 420750
//    결제 방식 할인: 현금 결제이므로 2% 추가 할인, 420750 * 0.98 = 412335
//    특별 프로모션: 할인 적용 전의 총 구매 금액이 500,000원 이상, 플래티넘 회원, 현금 결제이므로 50,000원 추가 할인, 412335 - 50000 = 362335
    public static void main(String[] args) {
        System.out.println(Solution.solution(550000,"플래티넘", "현금"));

    }

    class Solution {
        public static int solution(int totalPrice, String membership, String paymentMethod) {
            int answer = 0;
            int payPrise = 0;
            if(totalPrice >=500000){
                payPrise = (int)(totalPrice * (1-0.15));
            }else if(totalPrice>=300000){
                payPrise = (int)(totalPrice *(1-0.10));
            }else if(totalPrice>=100000){
                payPrise = (int)(totalPrice *(1-0.05));
            }
            switch (membership){
                case "실버":
                    payPrise = (int)(payPrise * (1-0.03));
                    break;
                case "골드":
                    payPrise = (int)(payPrise * (1-0.05));
                    break;
                case "플래티넘":
                    payPrise = (int)(payPrise * (1-0.1));

            }
            if(paymentMethod.equals("현금")){
                payPrise = (int)(payPrise * (1-0.02));
            }
            if(totalPrice >= 500000 && membership.equals("플래티넘") && paymentMethod.equals("현금")){
                payPrise = payPrise - 50000;
            }
            return answer = payPrise;
        }
    }
}
