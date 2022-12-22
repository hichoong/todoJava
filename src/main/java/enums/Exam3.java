package enums;
/**
 * 열거형 클래스에 추상메서드 사용해보기
 * 열거형에 추상메서드를 사용하면 상수마다 메서드를 구현해야 하는데, 상수에 특정 조건을 추가할 때 사용하는 것으로 추정된다.
 * 마치 익명 클래스를 작성하는 것과 유사한것 처럼 보인다.
 */

public class Exam3 {
    public static void main(String[] args) {
        System.out.println("bus fare = " + Transportation.BUS.fare(100));
        System.out.println("train fare = " + Transportation.TRAIN.fare(100));
        System.out.println("ship fare = " + Transportation.SHIP.fare(100));
        System.out.println("airplane fare = " + Transportation.AIRPLANE.fare(100));
    }
}
