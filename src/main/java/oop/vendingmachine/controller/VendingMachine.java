package oop.vendingmachine.controller;

import oop.vendingmachine.view.Choice;

import java.util.Scanner;

import static oop.vendingmachine.model.Beverage.*;

public class VendingMachine {
    Scanner scanner = new Scanner(System.in);
    Choice choice = new Choice();
    private boolean isStart = false;
    public void activateMachine() {
        while (!isStart) {
            int selectNum = choice.machineStart();
            if (selectNum != 1) {
                break;
            }
            int menuChoiceNum = choice.menuChoice();
            if (menuChoiceNum == 0) {
                break;
            }
            choice.menuCount(menuChoiceNum);
            }
    }
}

