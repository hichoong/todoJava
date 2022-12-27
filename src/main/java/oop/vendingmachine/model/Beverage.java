package oop.vendingmachine.model;

public enum Beverage {
    COKE("콜라", 1000) {
        public int totalPrice(int count) {
            return count * PRICE;
        }
    }
    , SPRITE("스프라이트", 1000) {
        public int totalPrice(int count) {
            return count * PRICE;
        }
    }
    , COFFEE("커피", 2000) {
        public int totalPrice(int count) {
            return count * PRICE;
        }
    }
    , TEE("차", 2500) {
        public int totalPrice(int count) {
            return count * PRICE;
        }
    };
    protected final String NAME;
    protected final int PRICE;

    Beverage(String NAME, int PRICE) {
        this.NAME = NAME;
        this.PRICE = PRICE;
    }

    public String getNAME() {
        return NAME;
    }

    public int getPRICE() {
        return PRICE;
    }

    public abstract int totalPrice(int count); //추상 메서드
}
