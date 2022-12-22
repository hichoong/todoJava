package generic;

/**
 * 제네릭 클래스의 객체 생성과 사용
 * 유의해야 할 점
 * 1. 참조변수와 생성자에 대입된 타입이 일치해야 함. (JDK 1.7에서 부터는 생성자 부분 제네릭 생략가능)
 * 2. 제네릭 클래스간 상속관계에 있고, 대입된 타입이 같은 것은 괜챃음
 *  ex) Box<apple> appleBox = new FruitBox<Apple> // Box가 FruitBox의 부모클래스이고 대입된 타입이 같을 시
 *
 */

public class exam2 {
    public static void main(String[] args) {
        Box<Fruit> fruitBox = new Box<Fruit>();
        Box<Apple> appleBox = new Box<Apple>();
        Box<Toy> toyBox = new Box<Toy>();
        //Box<Grape> grapeBox = new Box<Fruit>(); //에러, 타입 불일치

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());
        //appleBox.add(new Fruit()); //에러, 부모타입 넣기 불가

        appleBox. add(new Apple());
        appleBox. add(new Apple());
        toyBox.add(new Toy());

        System.out.println(fruitBox);
        System.out.println(appleBox);
        System.out.println(toyBox);
    }
}
interface Eatable{}
class Fruit implements Eatable {public String toString() {return "Fruit";}}
class Apple extends Fruit {public String toString() {return "Apple";}}
class Grape extends Fruit {public String toString() {return "Grape";}}
class Toy {public String toString() {return "Toy";}}
