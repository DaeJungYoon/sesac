package org.example.modifierprac;

public class BankAccount2 {
    private int balance;
    private String password;
//    public int accountNum;

    public BankAccount2(String password) {
//        if(!validateInitialPassword(password)){
//            System.out.println("invalid password");
//            return;
//        }else {
//
//        this.password = password;
//        }
        this.password = password;

//        this.balance = 0;
//        balance는 어차피 0일 것이기 때문에
//        this.accountNum = accountNum;
//        this.balance = balance;
    }
//    입금
//    input : 입금할 금액 / balance를 키움/ balance를 return{할까 하다가, 이미 getter가 존재하기 때문에 void를 return하자
    public void deposit(int amount){
        if(!validateAmount(amount)){
            System.out.println("cannot deposit");
            return;
//            함수를 끝낸다, 값을 반환한다,
        }
        balance += amount;
        System.out.println(amount+"won is deposit");

    }

//    출금(비밀번호 확인 필요)
//    input: 출금할 금액 / 비밀번호// 비밀번호 체크 / 잔액을 balance만큼 줄임 / return void(또는 int)
    public void withdraw(int amount, String password){
        if(!validatePassord(password)){
            System.out.println(("invalid password"));
            return;
        }
        if(!validateAmount(amount)){
            System.out.println("cannot withdraw");
            return;
        }

//        //비밀번호 확인
//        if(amount <= 0){
//            return;
//        }
//        출금 금액이 잔고보다 많으면 안됨
        if(amount>balance){
            return;
        }
        System.out.println(amount + "won is withdrawed");
        balance -= amount;
    }

//    잔액 조회(비밀번호 확인 필요)
    public int getBalance(String password) {
        //비밀번호 확인
        if(!validatePassord(password)){
            System.out.println("invalid password");
//            처리 첫번째: 의미 없는 값을 return(대신, typing에 맞춰서)
            return 0;
//            처리 두번째 : 에러 헨들링을 한다.
        }
        System.out.println(balance);
        return balance;

    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    private boolean validateAmount(int amount){
        if(amount>0){
            return true;
        }else {
            System.out.println("under 0 impossible");
            return false;
        }
    }

    private boolean validatePassord(String password){
        return this.password.equals((password));
//        if(this.password.equals(password)){
//            return true;
//        }else {

//            return false;
//        }

    }
    public static boolean initialvalidation(String password){
        if(password.length() >=4){
            return true;
        }else {
            System.out.println("invalid password");
            return false;
        }
    }
}


