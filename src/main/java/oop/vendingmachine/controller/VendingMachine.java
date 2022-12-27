package oop.vendingmachine.controller;

import oop.vendingmachine.view.Choice;

import java.util.Scanner;

public class VendingMachine {
    Scanner scanner = new Scanner(System.in);
    Choice choice = new Choice();
    private boolean isStart = false;
    private int money;
    public void activateMachine() {
        isStart = choice.machineStart();
        if (isStart== false) {
            money = inputMoney();
            while (!isStart) {
                int menuChoiceNum = choice.menuChoice();
                if (menuChoiceNum == 0) {
                    break;
                }
                int  totalPrice= choice.menuCount(menuChoiceNum);
                if (money < totalPrice) {
                    int selectCountinueMachine = laackOfMoney();
                    if (selectCountinueMachine > (money-totalPrice)) {
                        choice.lackView();
                        money += selectCountinueMachine;
                        break;
                    }
                    money += selectCountinueMachine;
                    if (selectCountinueMachine == 2) {
                        break;
                    }
                }
                money = money - totalPrice;
                System.out.println("남은 금액은 " +  money + "입니다.");
            }
        }
        System.out.println(money + "원 돌려드리겠습니다.");
        System.out.println("다믐에 또 이용해 주세요.");
    }

    public int inputMoney() {
        System.out.println("금액을 넣어 주세요. 금액은 5만원 미만으로 넣어주세요.");
        int money = scanner.nextInt();
            if (money <50000 && money > 0) {
                return money;
            }
        System.out.println("금액을 다시 확인해 주세요.");
            return inputMoney();
    }

    public int laackOfMoney() {
        System.out.println("잔액이 부족합니다.");
        System.out.println("금액을 충전하시겠습니까? 1 : 예 , 2 : 아니오." );
        int choieNum = scanner.nextInt();
        if (choieNum == 1) {
            return inputMoney();
        }
        if (choieNum == 2) {
            System.out.println("금액을 충전하지 않습니다.");
            return choieNum;
        } else {
            System.out.println("잘못된 선택을 하셨습니다.");
            return 2;
        }
    }
}

