package oop.vendingmachine;
import oop.vendingmachine.controller.VendingMachine;
import oop.vendingmachine.view.Choice;

import static oop.vendingmachine.model.Beverage.*;

public class Main {
    public static void main(String[] args) {

        System.out.println(COKE.getNAME() + "=" + COKE.totalPrice(5));
        System.out.println(COFFEE + "=" + COFFEE.totalPrice(5));
        System.out.println(TEE.totalPrice(2));
        System.out.println(SPRITE.totalPrice(10));

        /*Choice choice = new Choice();*/
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.activateMachine();
    }
}
