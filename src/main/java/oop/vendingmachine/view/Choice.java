package oop.vendingmachine.view;


import java.util.Scanner;

import static oop.vendingmachine.model.Beverage.*;

import java.util.Scanner;

public class Choice {
    private final Scanner scanner = new Scanner(System.in);

    public int menuChoice() {
        System.out.print("어떤 메뉴를 고르시겠습니까? 1:콜라, 2:스프라이트, 3:커피, 4:차, 0 : 선택안함");
        int choiceNum = scanner.nextInt();
        switch (choiceNum) {
            case 0:
                System.out.println("메뉴를 선택하지 않아 종료하겠습니다.");
                break;
            case 1:
                System.out.println("선택하신 메뉴는 " + COKE.getNAME() + " 가격은 " + COKE.getPRICE() + "입니다.");
                return choiceNum;
            case 2:
                System.out.println("선택하신 메뉴는 " + COKE.getNAME() + " 가격은 " + SPRITE.getPRICE() + "입니다.");
                return choiceNum;
            case 3:
                System.out.println("선택하신 메뉴는 " + COKE.getNAME() + " 가격은 " + COFFEE.getPRICE() + "입니다.");
                return choiceNum;
            case 4:
                System.out.println("선택하신 메뉴는 " + COKE.getNAME() + " 가격은 " + TEE.getPRICE() + "입니다.");
                return choiceNum;
            default:
                System.out.println("해당 메뉴는 존재하지 않습니다.");
                return menuChoice();
        }
        return choiceNum;
    }

    public void menuCount(int num) {
        System.out.println("메뉴의 수량을 입력해 주세요.");
        int countMenu = scanner.nextInt();
        if (num == 1) {
            System.out.println("총 금액은 " + COKE.totalPrice(countMenu) + "입니다.");
        }
        if (num == 2) {
            System.out.println("총 금액은 " + COKE.totalPrice(countMenu) + "입니다.");
        }
        if (num == 3) {
            System.out.println("총 금액은 " + COKE.totalPrice(countMenu) + "입니다.");
        }
        if (num == 4) {
            System.out.println("총 금액은 " + COKE.totalPrice(countMenu) + "입니다.");
        }
    }

    public int machineStart() {
        System.out.println("안녕하세요~ 충희네 자판기 입니다");
        System.out.println("자판기를 이용하시겠습니까? " + "1: 예 , 2: 아니오.");
        int selectNum = scanner.nextInt();
        switch (selectNum) {
            case 1:
                System.out.println("감사합니다.");
                break;
            case 2:
                System.out.println("다음엔 이용해 주세요.");
                break;
            default:
                System.out.println("다시 이용해 주세요.");
                return menuChoice();
        }
        return selectNum;
    }
}
